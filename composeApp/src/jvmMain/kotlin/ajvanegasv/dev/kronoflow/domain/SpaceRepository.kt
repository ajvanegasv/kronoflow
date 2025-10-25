package ajvanegasv.dev.kronoflow.domain

import ajvanegasv.dev.kronoflow.domain.model.Space
import org.jetbrains.exposed.v1.core.dao.id.EntityID

interface SpaceRepository {
    fun create(name: String): Space?
    fun getAll(): List<Space>
    fun getById(id: EntityID<Int>): Space?
    fun delete(id: EntityID<Int>): Boolean
    fun rename(id: EntityID<Int>, name: String): Space?
}