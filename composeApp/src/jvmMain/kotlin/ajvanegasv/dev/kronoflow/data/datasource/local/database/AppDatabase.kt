package ajvanegasv.dev.kronoflow.data.datasource.local.database

import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.transactions.transaction
import java.io.File

object AppDatabase {
    fun initialize() {
        val dbPath = File(System.getProperty("user.home"), "kronoflow.db").absolutePath
        Database.connect(
            url = "jdbc:sqlite:$dbPath",
            driver = "org.sqlite.JDBC"
        )

        transaction {  }
    }
}