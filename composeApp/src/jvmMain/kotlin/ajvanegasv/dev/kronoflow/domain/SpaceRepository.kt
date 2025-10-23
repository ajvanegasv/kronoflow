package ajvanegasv.dev.kronoflow.domain

import ajvanegasv.dev.kronoflow.domain.model.Space

interface SpaceRepository {
    fun create(name: String): Space?
    fun getAll(): List<Space>
    fun getById(id: Int): Space?
    fun delete(id: Int)
    fun rename(id: Int, name: String): Space?
}