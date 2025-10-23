package ajvanegasv.dev.kronoflow.domain.model

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.v1.core.dao.id.EntityID

data class Space (
    val id: EntityID<Int>,
    val name: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)