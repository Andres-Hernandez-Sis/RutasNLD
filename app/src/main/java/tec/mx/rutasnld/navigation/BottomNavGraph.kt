package tec.mx.rutasnld.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tec.mx.rutasnld.screens.HomeScreen
import tec.mx.rutasnld.screens.MapScreen
import tec.mx.rutasnld.screens.OtherScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarItems.Home.route)
    {
        composable(route = BottomBarItems.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarItems.Rutas.route){
            MapScreen()
        }
        composable(route = BottomBarItems.Otros.route){
            OtherScreen()
        }
    }
}
