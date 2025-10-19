package ajvanegasv.dev.kronoflow

import ajvanegasv.dev.kronoflow.ui.common.theme.KronoTheme
import ajvanegasv.dev.kronoflow.ui.home.Home
import androidx.compose.runtime.*

@Composable
fun App() {
    KronoTheme {
        Home()
    }
}