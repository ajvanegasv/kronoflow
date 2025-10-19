package ajvanegasv.dev.kronoflow.data.datasource.local.database

import ajvanegasv.dev.kronoflow.data.datasource.local.schemas.Spaces
import ajvanegasv.dev.kronoflow.data.datasource.local.schemas.Tasks
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.transactions.transaction
import java.io.File

object AppDatabase {
    fun initialize() {
        val userHome = System.getProperty("user.home")
        val kronoflowDir = File(userHome, ".kronoflow")

        if (!kronoflowDir.exists()) {
            kronoflowDir.mkdir()
        }

        val dbPath = File(kronoflowDir, "kronoflow.db").absolutePath

        Database.connect(
            url = "jdbc:sqlite:$dbPath",
            driver = "org.sqlite.JDBC"
        )

        transaction {
            SchemaUtils.create(Spaces)
            SchemaUtils.create(Tasks)
        }
    }
}