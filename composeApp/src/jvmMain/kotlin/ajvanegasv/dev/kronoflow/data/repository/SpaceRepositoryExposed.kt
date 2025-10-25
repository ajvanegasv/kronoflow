package ajvanegasv.dev.kronoflow.data.repository

import ajvanegasv.dev.kronoflow.data.datasource.local.dao.SpaceDao
import ajvanegasv.dev.kronoflow.domain.SpaceRepository
import ajvanegasv.dev.kronoflow.domain.model.Space
import org.jetbrains.exposed.v1.core.dao.id.EntityID

class SpaceRepositoryExposed(
    val spaceDao: SpaceDao,
): SpaceRepository {
    override fun create(name: String): Space {
        val spaceExposedEntity = spaceDao.create(name)
        return Space(
            id = spaceExposedEntity.id,
            name = spaceExposedEntity.name,
            createdAt = spaceExposedEntity.createdAt,
            updatedAt = spaceExposedEntity.updatedAt,
            lastViewed = spaceExposedEntity.lastViewed,
        )
    }

    override fun getAll(): List<Space> {
        val spacesExposedEntity = spaceDao.getAll()
        return spacesExposedEntity.map {
            Space(
                id = it.id,
                name = it.name,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt,
                lastViewed = it.lastViewed,
            )
        }
    }

    override fun getById(id: EntityID<Int>): Space? {
        val spaceExposedEntity = spaceDao.getById(id) ?: return null
        return Space(
            id = spaceExposedEntity.id,
            name = spaceExposedEntity.name,
            createdAt = spaceExposedEntity.createdAt,
            updatedAt = spaceExposedEntity.updatedAt,
            lastViewed = spaceExposedEntity.lastViewed,
        )
    }

    override fun delete(id: EntityID<Int>): Boolean {
        try {
            spaceDao.delete(id)
            return true;
        } catch(_: Exception) {
            return false
        }

    }

    override fun rename(id: EntityID<Int>, name: String): Space? {
        val spaceExposedEntity = spaceDao.update(id, name) ?: return null
        return Space(
            id = spaceExposedEntity.id,
            name = spaceExposedEntity.name,
            createdAt = spaceExposedEntity.createdAt,
            updatedAt = spaceExposedEntity.updatedAt,
            lastViewed = spaceExposedEntity.lastViewed,
        )
    }

}