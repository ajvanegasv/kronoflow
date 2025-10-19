package ajvanegasv.dev.kronoflow.data.model

import ajvanegasv.dev.kronoflow.data.datasource.local.schemas.Tasks
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

class Task(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<Task>(Tasks)

    val name by Tasks.name
    val description by Tasks.description
    val status by Tasks.status
    val timeWorked by Tasks.timeWorked
    val dueDate by Tasks.dueDate
    val space by Tasks.space
    val createdAt by Tasks.createdAt
    val updatedAt by Tasks.updatedAt
}