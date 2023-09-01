package tec.mx.rutasnld

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: BottomBarScreen(
        route = "home",
        title = "home",
        icon = Icons.Default.LocationOn
    )
    object Mapas: BottomBarScreen(
        route = "mapas",
        title = "Mapas",
        icon = Icons.Default.DateRange
    )
    object Otros: BottomBarScreen(
        route = "otros",
        title = "Otros",
        icon = Icons.Default.List
    )

}
