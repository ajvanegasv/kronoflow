package ajvanegasv.dev.kronoflow.data.repository

import ajvanegasv.dev.kronoflow.data.datasource.local.dao.SpaceDao
import ajvanegasv.dev.kronoflow.domain.SpaceRepository
import ajvanegasv.dev.kronoflow.domain.model.Space

class SpaceRepositoryExposed(
    val spaceDao: SpaceDao,
): SpaceRepository {
    override fun create(name: String): Space? {
        val spaceExposedEntity = spaceDao.create(name)
        return Space(
            id = spaceExposedEntity.id,
            name = spaceExposedEntity.name,
            createdAt = spaceExposedEntity.createdAt,
            updatedAt = spaceExposedEntity.updatedAt,
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
            )
        }
    }

    override fun getById(id: Int): Space? {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override fun rename(id: Int, name: String): Space? {
        TODO("Not yet implemented")
    }

}