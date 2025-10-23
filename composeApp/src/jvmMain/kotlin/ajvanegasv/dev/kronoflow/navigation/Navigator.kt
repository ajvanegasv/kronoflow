package ajvanegasv.dev.kronoflow.navigation

import ajvanegasv.dev.kronoflow.ui.spaces.Spaces
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


val LocalNavigator = staticCompositionLocalOf<NavHostController> { error("Navigation not provided") }

@Composable
fun Navigation(navigator: NavHostController) {
    CompositionLocalProvider(LocalNavigator provides navigator) {
        NavHost(
            navController = navigator,
            startDestination = "/space"
        ) {
            composable(route = "/space") {
                Spaces()
            }
        }
    }
}