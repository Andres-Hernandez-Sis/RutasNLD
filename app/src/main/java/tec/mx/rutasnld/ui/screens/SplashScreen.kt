package tec.mx.rutasnld.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import tec.mx.rutasnld.navigation.BottomBarItems
import tec.mx.rutasnld.ui.components.Splash

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.popBackStack() //Para borrar el registro de navegacion, sirve para que no se pueda ir de nuevo hacia atras < o
        navController.navigate(route = BottomBarItems.Home.route)
    }
    Splash()
}
