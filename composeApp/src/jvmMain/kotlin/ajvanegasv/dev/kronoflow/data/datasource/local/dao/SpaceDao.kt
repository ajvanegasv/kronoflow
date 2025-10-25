package ajvanegasv.dev.kronoflow.data.datasource.local.dao

import ajvanegasv.dev.kronoflow.data.model.Space
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.jdbc.transactions.transaction
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

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

    fun getById(id: EntityID<Int>): Space? {
        return transaction {
            Space.findById(id)
        }
    }

    fun delete(id: EntityID<Int>) {
        val space = getById(id) ?: return

        transaction {
            space.delete()
        }
    }

    @OptIn(ExperimentalTime::class)
    fun update(id: EntityID<Int>, name: String): Space? {
        val space = getById(id) ?: return null
        return transaction {
            space.name = name
            space.updatedAt = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

            space
        }
    }
}