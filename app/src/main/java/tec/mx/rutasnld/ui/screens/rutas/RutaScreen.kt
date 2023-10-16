package tec.mx.rutasnld.ui.screens.rutas


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import tec.mx.rutasnld.navigation.RutasItems
import tec.mx.rutasnld.ui.screens.rutas.listado.Km10Panteon
import tec.mx.rutasnld.ui.screens.rutas.listado.MinaVoluntad
import tec.mx.rutasnld.ui.screens.rutas.listado.MiradorPanteon
import tec.mx.rutasnld.ui.screens.rutas.listado.MiradorReforma
import tec.mx.rutasnld.ui.screens.rutas.listado.VeinteNoviembreValles

@Composable
fun RutasScreen() {
    val currentScreen = remember { mutableStateOf<RutasItems?>(null) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        when (currentScreen.value) {
            RutasItems.MiradorPanteon -> MiradorPanteon()
            RutasItems.MiradorReforma -> MiradorReforma()
            RutasItems.MinaVoluntad -> MinaVoluntad()
            RutasItems.VeinteNoviembreValles -> VeinteNoviembreValles()
            RutasItems.Km10Panteon -> Km10Panteon()
            else -> MenuRutas(currentScreen)
        }
    }
}