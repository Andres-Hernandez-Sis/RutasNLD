package tec.mx.rutasnld.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
//import tec.mx.rutasnld.ui.components.Splash

//@Composable
//fun SplashScreen(navController: NavHostController) {
//    LaunchedEffect(key1 = true) {
//        delay(3000)
//        navController.popBackStack() // Para borrar el registro de navegación, para que no se pueda ir de nuevo hacia atrás
//        navController.navigate(route = BottomBarItems.Home.route)
//    }
//
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        // Contenido de la pantalla de inicio aquí
//        Splash()
//    }
//}

