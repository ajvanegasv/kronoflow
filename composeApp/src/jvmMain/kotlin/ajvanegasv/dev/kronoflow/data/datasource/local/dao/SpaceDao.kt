package ajvanegasv.dev.kronoflow.data.datasource.local.dao

import ajvanegasv.dev.kronoflow.data.model.Space
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

class SpaceDao {
    fun create(name: String): Space {
        return transaction {
            Space.new {
                this.name = name
            }
        }
    }

    fun getAll(): List<Space> {
        return transaction {
            Space.all().toList()
        }
    }

    fun getById(id: Int): Space? {
        return transaction {
            Space.findById(id)
        }
    }

    fun delete(id: Int) {
        val space = getById(id) ?: return

        transaction {
            space.delete()
        }
    }
}