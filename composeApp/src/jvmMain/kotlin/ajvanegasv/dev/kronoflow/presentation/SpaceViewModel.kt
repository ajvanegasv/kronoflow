package ajvanegasv.dev.kronoflow.presentation

import ajvanegasv.dev.kronoflow.domain.SpaceRepository
import ajvanegasv.dev.kronoflow.domain.model.Space
import androidx.lifecycle.ViewModel

class SpaceViewModel(
    private val spaceRepository: SpaceRepository,
): ViewModel() {
    fun getAll(): List<Space> {
        return spaceRepository.getAll()
    }
}