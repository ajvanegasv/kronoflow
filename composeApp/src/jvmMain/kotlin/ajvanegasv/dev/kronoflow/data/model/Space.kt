package ajvanegasv.dev.kronoflow.data.model

import ajvanegasv.dev.kronoflow.data.datasource.local.schemas.Spaces
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

class Space(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<Space>(Spaces)

    var name by Spaces.name
    var createdAt by Spaces.createdAt
    var updatedAt by Spaces.updatedAt
    var lastViewed by Spaces.lastViewed
}