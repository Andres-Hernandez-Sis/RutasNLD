package tec.mx.rutasnld.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import tec.mx.rutasnld.R

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


