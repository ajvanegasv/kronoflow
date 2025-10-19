package ajvanegasv.dev.kronoflow.data.datasource.local.schemas

import org.jetbrains.exposed.v1.core.dao.id.IntIdTable
import org.jetbrains.exposed.v1.datetime.CurrentDateTime
import org.jetbrains.exposed.v1.datetime.datetime

object Spaces : IntIdTable("Spaces") {
    val name = varchar("name", 255)
    val createdAt = datetime("createdAt").defaultExpression(CurrentDateTime)
    val updatedAt = datetime("updatedAt").defaultExpression(CurrentDateTime)
}