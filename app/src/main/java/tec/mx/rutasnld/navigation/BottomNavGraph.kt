package tec.mx.rutasnld.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tec.mx.rutasnld.screens.MapScreen
import tec.mx.rutasnld.screens.OtherScreen
import tec.mx.rutasnld.screens.RutaScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarItems.Home.route)
    {
        composable(route = BottomBarItems.Home.route){
            MapScreen()
        }
        composable(route = BottomBarItems.Rutas.route){
            RutaScreen()
        }
        composable(route = BottomBarItems.Otros.route){
            OtherScreen()
        }
    }
}
