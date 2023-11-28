package tec.mx.rutasnld.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tec.mx.rutasnld.ui.screens.mapeinteractivo.MapScreen
import tec.mx.rutasnld.ui.screens.info.InfoScreen
import tec.mx.rutasnld.network.NetworkViewModel
import tec.mx.rutasnld.ui.screens.rutas.RutasScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarItems.Home.route,
        route = ROOT_ROUTE
    ) {
        composable(route = BottomBarItems.Home.route) {
            MapScreen(networkViewModel = NetworkViewModel())
        }

        composable(route = BottomBarItems.Info.route) {
            InfoScreen()
        }

        composable(route = BottomBarItems.Rutas.route) {
            RutasScreen()
        }

    }
}

