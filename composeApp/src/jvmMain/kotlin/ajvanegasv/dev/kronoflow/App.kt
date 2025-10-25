package ajvanegasv.dev.kronoflow

import ajvanegasv.dev.kronoflow.navigation.Navigation
import ajvanegasv.dev.kronoflow.ui.common.theme.KronoTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController

@Composable
fun App() {
    val navigator = rememberNavController()
    Scaffold (
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        KronoTheme {
            Navigation(navigator)
        }
    }
}