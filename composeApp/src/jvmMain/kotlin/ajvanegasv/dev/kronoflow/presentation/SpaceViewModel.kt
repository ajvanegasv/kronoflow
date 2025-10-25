package ajvanegasv.dev.kronoflow.presentation

import ajvanegasv.dev.kronoflow.domain.SpaceRepository
import ajvanegasv.dev.kronoflow.domain.model.Space
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.jetbrains.exposed.v1.core.dao.id.EntityID

class SpaceViewModel(
    private val spaceRepository: SpaceRepository,
): ViewModel() {
    private val _spacesState = MutableStateFlow<List<Space>>(emptyList())
    val spacesState = _spacesState.asStateFlow()

    init {
        _spacesState.value = getAll()
    }
    fun getAll(): List<Space> {
        return spaceRepository.getAll()
    }

    private fun replaceSpaceInState(space: Space) {
        val index = _spacesState.value.indexOfFirst { it.id == space.id }
        if (index != -1) {
            _spacesState.value = _spacesState.value.toMutableList().apply {
                set(index, space)
            }
        }
    }

    fun rename(id: EntityID<Int>, name: String) {
        val spaceRenamed = spaceRepository.rename(id, name) ?: return
        replaceSpaceInState(spaceRenamed)
    }
}