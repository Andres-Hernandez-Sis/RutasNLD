package tec.mx.rutasnld.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tec.mx.rutasnld.ui.screens.mapeo.MapScreen
import tec.mx.rutasnld.ui.screens.info.InfoScreen
import tec.mx.rutasnld.ui.screens.mapeo.MapViewModel
import tec.mx.rutasnld.ui.screens.rutas.RutaScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarItems.Home.route)
    {
//        composable(route = ScreenRoot.SplashScreen.route){
//            SplashScreen(navController)
//        }
        composable(route = BottomBarItems.Home.route){
            MapScreen(mapViewModel = MapViewModel())
        }
        composable(route = BottomBarItems.Rutas.route){
            RutaScreen(navController)
        }
        composable(route = BottomBarItems.Otros.route){
            InfoScreen()
        }
    }
}

