package ajvanegasv.dev.kronoflow.data.datasource.local.schemas

import kotlinx.datetime.LocalTime
import org.jetbrains.exposed.v1.core.ReferenceOption
import org.jetbrains.exposed.v1.core.dao.id.IntIdTable
import org.jetbrains.exposed.v1.datetime.CurrentDateTime
import org.jetbrains.exposed.v1.datetime.date
import org.jetbrains.exposed.v1.datetime.datetime
import org.jetbrains.exposed.v1.datetime.time

object Task: IntIdTable("Tasks") {
    var name = varchar("name", 255)
    var description = varchar("description", 255).nullable()
    var status = varchar("status", 255)
    var executionTime = long("executionTime").default(0)
    var dueDate = date("dueDate").nullable()
    var space = optReference("space", Space.id, onDelete = ReferenceOption.CASCADE)
    var createdAt = datetime("createdAt").defaultExpression(CurrentDateTime)
    var updatedAt = datetime("updatedAt").defaultExpression(CurrentDateTime)
}