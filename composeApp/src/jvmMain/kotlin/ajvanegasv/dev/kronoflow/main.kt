package ajvanegasv.dev.kronoflow

import ajvanegasv.dev.kronoflow.data.datasource.local.database.AppDatabase
import ajvanegasv.dev.kronoflow.di.initKoin
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    initKoin()
    AppDatabase.initialize()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Kronoflow",
        alwaysOnTop = true,
    ) {
        App()
    }
}