package ajvanegasv.dev.kronoflow.presentation.space

import ajvanegasv.dev.kronoflow.domain.SpaceRepository
import ajvanegasv.dev.kronoflow.domain.model.Space
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.jetbrains.exposed.v1.core.dao.id.EntityID

class SpaceViewModel(
    private val spaceRepository: SpaceRepository,
): ViewModel() {
    private val _spacesState = MutableStateFlow<SpacesUiState>(SpacesUiState())
    val spacesState = _spacesState.asStateFlow()

    init {
        _spacesState.value = SpacesUiState(spaces = getAll())
    }

    fun getAll(): List<SpaceUiState> {
         return spaceRepository.getAll().map { space ->
             SpaceUiState(
                 space = space,
             )
         }
    }

    private fun replaceSpaceInState(space: Space) {
        val index = _spacesState.value.spaces.indexOfFirst { it.space.id == space.id }
        if (index != -1) {
            _spacesState.value = _spacesState.value.copy(
                spaces = _spacesState.value.spaces.toMutableList().apply {
                    set(index, SpaceUiState(space = space))
                }
            )
        }
    }

    fun rename(id: EntityID<Int>, name: String) {
        val spaceRenamed = spaceRepository.rename(id, name) ?: return
        replaceSpaceInState(spaceRenamed)
    }

    fun create() {
        val space = spaceRepository.create("My new space") ?: return
        val spaceUiState = SpaceUiState(space = space)

        _spacesState.value = _spacesState.value.copy(
            spaces = listOf(spaceUiState) + _spacesState.value.spaces,
        )
    }

    fun delete(id: EntityID<Int>) {
        val isDelete = spaceRepository.delete(id)

        if (isDelete) {
            _spacesState.value = _spacesState.value.copy(
                spaces = _spacesState.value.spaces.filter { spaceUiState -> spaceUiState.space.id != id }
            )
        }
    }
}