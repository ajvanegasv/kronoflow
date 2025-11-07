package ajvanegasv.dev.kronoflow.presentation.space

import ajvanegasv.dev.kronoflow.domain.model.Space
import org.jetbrains.exposed.v1.core.dao.id.EntityID

data class SpacesUiState(
    val spaces: List<SpaceUiState> = emptyList(),
    val error : String? = null,
)

data class SpaceUiState(
    val space: Space,
    val totalTasks: Int = 0,
    val completedTasks: Int = 0,
    val overdueTasks: Int = 0,
)
