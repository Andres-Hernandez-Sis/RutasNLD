package tec.mx.rutasnld.ui.screens.rutas

import android.content.Context
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tec.mx.rutasnld.navigation.RutasItems
import tec.mx.rutasnld.ui.components.CustomButton


@Composable
fun RutasScreen() {
    val currentScreen = remember { mutableStateOf<RutasItems?>(null) }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        when (currentScreen.value) {
            RutasItems.VeinteNoviembreCampanario -> RutaCamionComposable("20 de Noviembre Campanario",       "20NoviembreCampanario.html")
            RutasItems.VeinteNoviembreValles -> RutaCamionComposable("20 de Noviembre Valles", "20NoviembreValles.html")
            RutasItems.CavazosLerma -> RutaCamionComposable("Cavazos Lerma",         "CavazosLerma.html")
            RutasItems.Conalep150Aniversario -> RutaCamionComposable("Conalep 150 Aniversario",         "Conalep150Aniversario.html")
            RutasItems.ConalepCampanario -> RutaCamionComposable("Conalep Campanario",    "ConalepCampanario.html")
            RutasItems.ConalepReservas -> RutaCamionComposable("Conalep Reservas",    "ConalepReservas.html")
            RutasItems.ConalepVillasValles -> RutaCamionComposable("Conalep Villas Valles",    "ConalepVillasValles.html")
            RutasItems.Km10xColinas -> RutaCamionComposable("Km 10 x Colinas",    "Km10xColinas.html")
            RutasItems.Km10xPanteon -> RutaCamionComposable("Km 10 X Panteon",    "Km10xPanteon.html")
            RutasItems.Km12 -> RutaCamionComposable("Km 12",    "Km12.html")
            RutasItems.Km13x15 -> RutaCamionComposable("Km 13 x 15",    "Km13x15.html")
            RutasItems.Km15x18 -> RutaCamionComposable("Km 15 x 18",    "Km15x18.html")
            RutasItems.LdoTexasxBenitoJuarez -> RutaCamionComposable("Laredo Texas X Benito Juarez",    "LdoTexasxBenitoJuarez.html")
            RutasItems.MinaConstitucional -> RutaCamionComposable("Mina Constitucional",    "MinaConstitucional.html")
            RutasItems.MinaVoluntad -> RutaCamionComposable("Mina Voluntad",        "MinaVoluntad.html")
            RutasItems.MiradorPanteon -> RutaCamionComposable("Mirador Panteon",    "MiradorPanteon.html")
            RutasItems.MiradorReforma -> RutaCamionComposable("Mirador Reforma",    "MiradorReforma.html")
            RutasItems.NacionesUnidas -> RutaCamionComposable("Naciones Unidas",    "NacionesUnidas.html")
            RutasItems.NogalxCentral -> RutaCamionComposable("Nogal x Central",    "NogalxCentral.html")
            RutasItems.NogalxCoca -> RutaCamionComposable("Nogal x Coca",    "NogalxCoca.html")
            RutasItems.Olivos -> RutaCamionComposable("Olivos",    "Olivos.html")
            RutasItems.PanteonBolivar -> RutaCamionComposable("Panteon Bolivar",    "PanteonBolivar.html")
            RutasItems.ReservasArteaga -> RutaCamionComposable("Reservas Arteaga",    "ReservasArteaga.html")
            RutasItems.ReservasViaRapida -> RutaCamionComposable("Reservas Via Rapida",    "ReservasViaRapida.html")
            RutasItems.Riverena -> RutaCamionComposable("Rivereña",    "Riverena.html")
            RutasItems.UnionRecuerdo -> RutaCamionComposable("Union del Recuerdo",    "UnionRecuerdo.html")
            RutasItems.VictoriaViveros -> RutaCamionComposable("Victoria Viveros",    "VictoriaViveros.html")
            RutasItems.Virreyes -> RutaCamionComposable("Virreyes",    "Virreyes.html")
            else -> MenuRutas(currentScreen)
        }
    }
}



@Composable
fun MenuRutas(currentScreen: MutableState<RutasItems?>) {
    val rutas = listOf(
        "20 de noviembre Campanario",
        "20 de Noviembre Valles",
        "Cavazos Lerma",
        "Conalep 150 Aniversario",
        "Conalep Campanario",
        "Conalep Reservas",
        "Conalep Villas Valles",
        "Km 10 x Colinas",
        "Km 10 X Panteon",
        "Km 12",
        "Km13 x 15",
        "Km 15 x 18",
        "Laredo Texas X Benito Juarez",
        "Mina Constitucional",
        "Mina Voluntad",
        "Mirador Panteon",
        "Mirador Reforma",
        "Naciones Unidas",
        "Nogal x Central",
        "Nogal x Coca",
        "Olivos",
        "Panteon Bolivar",
        "Reservas Arteaga",
        "Reservas Via Rapida",
        "Rivereña",
        "Union del Recuerdo",
        "Victoria Viveros",
        "Virreyes"
    )



    val context = LocalContext.current
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    var isFirstClick by remember { mutableStateOf(sharedPreferences.getBoolean("firstClick", true)) }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        item {
            Text(
                text = "Listado de Rutas 🚌",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
            Spacer(Modifier.height(7.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp)
            )
            Spacer(Modifier.height(10.dp))
        }

        items(rutas) { ruta ->
            CustomButton(
                text = ruta,
                onClick = {
                    if (isFirstClick) {
                        showToast(context, "Para volver, haz clic en Rutas")
                        isFirstClick = false
                        // Guardar el estado en SharedPreferences
                        sharedPreferences.edit().putBoolean("firstClick", false).apply()
                    }
                    currentScreen.value = getRutaItemFromString(ruta)
                }
            )
            Spacer(Modifier.height(10.dp))
        }
    }
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

// Función auxiliar para convertir el nombre de la ruta a un enum RutasItems
fun getRutaItemFromString(ruta: String): RutasItems? {
    return when (ruta) {
        "20 de noviembre Campanario" -> RutasItems.VeinteNoviembreCampanario
        "20 de Noviembre Valles" -> RutasItems.VeinteNoviembreValles
        "Cavasos Lerma" -> RutasItems.CavazosLerma
        "Conalep 150 Aniversario" -> RutasItems.Conalep150Aniversario
        "Conalep Campanario" -> RutasItems.ConalepCampanario
        "Conalep Reservas" -> RutasItems.ConalepReservas
        "Conalep Villas Valles" -> RutasItems.ConalepVillasValles
        "Km 10 x Colinas" -> RutasItems.Km10xColinas
        "Km 10 X Panteon" -> RutasItems.Km10xPanteon
        "Km 12" -> RutasItems.Km12
        "Km13 x 15" -> RutasItems.Km13x15
        "Km 15 x 18" -> RutasItems.Km15x18
        "Laredo Texas X Benito Juarez" -> RutasItems.LdoTexasxBenitoJuarez
        "Mina Constitucional" -> RutasItems.MinaConstitucional
        "Mina Voluntad" -> RutasItems.MinaVoluntad
        "Mirador Panteon" -> RutasItems.MiradorPanteon
        "Mirador Reforma" -> RutasItems.MiradorReforma
        "Naciones Unidas" -> RutasItems.NacionesUnidas
        "Nogal x Central" -> RutasItems.NogalxCentral
        "Nogal x Coca" -> RutasItems.NogalxCoca
        "Olivos" -> RutasItems.Olivos
        "Panteon Bolivar" -> RutasItems.PanteonBolivar
        "Reservas Arteaga" -> RutasItems.ReservasArteaga
        "Reservas Via Rapida" -> RutasItems.ReservasViaRapida
        "Rivereña" -> RutasItems.Riverena
        "Union del Recuerdo" -> RutasItems.UnionRecuerdo
        "Victoria Viveros" -> RutasItems.VictoriaViveros
        "Virreyes" -> RutasItems.Virreyes
        else -> null
    }
}



