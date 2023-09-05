package tec.mx.rutasnld

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tec.mx.rutasnld.screens.HomeScreen
import tec.mx.rutasnld.screens.MapScreen
import tec.mx.rutasnld.screens.OtherScreen

@Composable
fun NavigationHost(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarItems.Home.route)
    {
        composable(route = BottomBarItems.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarItems.Mapas.route){
            MapScreen()
        }
        composable(route = BottomBarItems.Otros.route){
            OtherScreen()
        }
    }
}

