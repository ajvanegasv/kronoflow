package ajvanegasv.dev.kronoflow.navigation

import ajvanegasv.dev.kronoflow.ui.spaces.SpacesScreen
import ajvanegasv.dev.kronoflow.ui.tasks.TasksScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

val LocalNavigator = staticCompositionLocalOf<NavHostController> { error("Navigation not provided") }



@Composable
fun Navigation(navigator: NavHostController) {
    CompositionLocalProvider(LocalNavigator provides navigator) {
        NavHost(
            navController = navigator,
            startDestination = SpacesRoute
        ) {
            composable<SpacesRoute> {
                SpacesScreen(navigator)
            }

            composable<SpaceRoute> { backStackEntry ->
                val space: SpaceRoute = backStackEntry.toRoute()
                TasksScreen(navigator, space.id)
            }
        }
    }
}