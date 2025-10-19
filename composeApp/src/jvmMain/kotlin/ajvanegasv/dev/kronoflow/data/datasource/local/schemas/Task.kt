package ajvanegasv.dev.kronoflow.data.datasource.local.schemas

import org.jetbrains.exposed.v1.core.ReferenceOption
import org.jetbrains.exposed.v1.core.dao.id.IntIdTable

object Task: IntIdTable() {
    var name = varchar("name", 255)
    var description = varchar("description", 255).nullable()
    var status = varchar("status", 255)
    var executionTime = long("executionTime")
    var dueDate = long("dueDate").nullable()
    var space = optReference("space", Space.id, onDelete = ReferenceOption.CASCADE)
    var createdAt = long("createdAt")
    var updatedAt = long("updatedAt")
}