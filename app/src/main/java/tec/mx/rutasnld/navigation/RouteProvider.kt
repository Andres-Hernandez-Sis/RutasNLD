package tec.mx.rutasnld.navigation

import androidx.navigation.NavHostController

interface RouteProvider {

    fun currentRoute(navController: NavHostController): String?


}