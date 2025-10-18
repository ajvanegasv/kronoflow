package ajvanegasv.dev.kronoflow

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Kronoflow",
        alwaysOnTop = true,
    ) {
        App()
    }
}