package tec.mx.rutasnld.navigation

import tec.mx.rutasnld.R

sealed class ScreenRoot( val route : String)
{
    object  SplashScreen : ScreenRoot("Splash")
}
sealed class BottomBarItems(
    val route: String,
    val title: String,
    val icon: Int
){
    object Home: BottomBarItems(
        route = "home",
        title = "Mapa",
        icon = R.drawable.mapa
    )
    object Rutas: BottomBarItems(
        route = "mapas",
        title = "Rutas",
        icon = R.drawable.ruta
    )
    object Otros: BottomBarItems(
        route = "otros",
        title = "Información",
        icon = R.drawable.otros
    )
}



