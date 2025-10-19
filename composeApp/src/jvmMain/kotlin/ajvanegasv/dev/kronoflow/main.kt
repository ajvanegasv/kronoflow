package ajvanegasv.dev.kronoflow

import ajvanegasv.dev.kronoflow.data.datasource.local.database.AppDatabase
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    AppDatabase.initialize()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Kronoflow",
        alwaysOnTop = true,
    ) {
        App()
    }
}