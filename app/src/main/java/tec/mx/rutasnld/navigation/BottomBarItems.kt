package tec.mx.rutasnld.navigation

import tec.mx.rutasnld.R


const val ROOT_ROUTE = "root"

sealed class RutasItems(
    val route: String
) {
    object Menu : RutasItems("menu")
    object MiradorPanteon : RutasItems("mirador_panteon")
    object MiradorReforma : RutasItems("mirador_reforma")
    object MinaVoluntad : RutasItems("mina_voluntad")
    object VeinteNoviembreValles : RutasItems("veinte_noviembre_valles")
    object Km10Panteon : RutasItems("km_diez_panteon")

}

sealed class BottomBarItems(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home : BottomBarItems("home", "Mapa", R.drawable.mapa)
    object Rutas : BottomBarItems("rutas", "Rutas", R.drawable.ruta)
    object Info : BottomBarItems("info", "Información", R.drawable.info)
}




