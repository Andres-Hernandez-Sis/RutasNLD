package tec.mx.rutasnld

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItems(
    val route: String,
    val title: String,
    val icon: ImageVector
    //Poner en tipo Int
){
    object Home: BottomBarItems(
        route = "home",
        title = "home",
        icon = Icons.Default.LocationOn
    )
    object Mapas: BottomBarItems(
        route = "mapas",
        title = "Mapas",
        icon = Icons.Default.DateRange
    )
    object Otros: BottomBarItems(
        route = "otros",
        title = "Otros",
        icon = Icons.Default.List
    )

}
