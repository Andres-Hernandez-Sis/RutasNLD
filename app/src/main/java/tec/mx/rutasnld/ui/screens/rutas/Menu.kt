package tec.mx.rutasnld.ui.screens.rutas

import android.content.Context
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tec.mx.rutasnld.navigation.RutasItems


@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)
            .padding(horizontal = 16.dp),
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp, pressedElevation = 0.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(156, 28, 53),
            contentColor = Color.White
        )
    ) {
        Text(text = text)
    }
}

@Composable
fun MenuRutas(currentScreen: MutableState<RutasItems?>) {
    val rutas = listOf(
        "Mirador Panteon",
        "Mirador Reforma",
        "Mina Voluntad",
        "20 de Noviembre Valles",
        "Km 10 X Panteon"
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
        "Mirador Panteon" -> RutasItems.MiradorPanteon
        "Mirador Reforma" -> RutasItems.MiradorReforma
        "Mina Voluntad" -> RutasItems.MinaVoluntad
        "20 de Noviembre Valles" -> RutasItems.VeinteNoviembreValles
        "Km 10 X Panteon" -> RutasItems.Km10Panteon
        else -> null
    }
}


