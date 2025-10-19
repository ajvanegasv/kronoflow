package ajvanegasv.dev.kronoflow.data.datasource.local.schemas

import org.jetbrains.exposed.v1.core.dao.id.IntIdTable

object Space : IntIdTable() {
    val name = varchar("name", 255)
    val createdAt = long("createdAt")
}