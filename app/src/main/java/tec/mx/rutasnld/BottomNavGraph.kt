package tec.mx.rutasnld

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
        startDestination = BottomBarScreen.Home.route)
    {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreen.Mapas.route){
            MapScreen()
        }
        composable(route = BottomBarScreen.Otros.route){
            OtherScreen()
        }
    }
}

