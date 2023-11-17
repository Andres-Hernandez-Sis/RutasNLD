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
    object Km10xPanteon : RutasItems("km_diez_panteon")
    object VeinteNoviembreCampanario : RutasItems("veinte_noviembre_campanario")
    object CavazosLerma : RutasItems("cavazos_lerma")
    object Conalep150Aniversario : RutasItems("conalep_150_aniversario")
    object ConalepCampanario : RutasItems("conalep_campanario")
    object ConalepReservas : RutasItems("conalep_reservas")
    object ConalepVillasValles : RutasItems("conalep_villas_valles")
    object Km10xColinas : RutasItems("km_diez_colinas")
    object Km12 : RutasItems("km_doce")
    object Km13x15 : RutasItems("km_trece_quince")
    object Km15x18 : RutasItems("km_quince_dieciocho")
    object LdoTexasxBenitoJuarez : RutasItems("ldo_texas_benito_juarez")
    object MinaConstitucional : RutasItems("mina_constitucional")
    object NacionesUnidas : RutasItems("naciones_unidas")
    object NogalxCentral : RutasItems("nogal_central")
    object NogalxCoca : RutasItems("nogal_coca")
    object Olivos : RutasItems("olivos")
    object PanteonBolivar : RutasItems("panteon_bolivar")
    object ReservasArteaga : RutasItems("reservas_arteaga")
    object ReservasViaRapida : RutasItems("reservas_via_rapida")
    object Riverena : RutasItems("riverena")
    object UnionRecuerdo : RutasItems("union_recuerdo")
    object VictoriaViveros : RutasItems("victoria_viveros")
    object Virreyes : RutasItems("virreyes")
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




