package tec.mx.rutasnld.ui.screens.rutas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tec.mx.rutasnld.navigation.RutasItems


@Composable
fun CustomButtom(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Color(115, 12, 44), shape = CircleShape)
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}

@Composable
fun MenuRutas(currentScreen: MutableState<RutasItems?>) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Listado de Rutas 🚌",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp).align(alignment = Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(10.dp))
        CustomButtom(
            text = "Mirador Panteon",
            onClick = { currentScreen.value = RutasItems.MiradorPanteon }
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        CustomButtom(
            text = "Mirador Reforma",
            onClick = { currentScreen.value = RutasItems.MiradorReforma }
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        CustomButtom(
            text = "Mina Voluntad",
            onClick = { currentScreen.value = RutasItems.MinaVoluntad }
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        CustomButtom(
            text = "20 de Noviembre Valles",
            onClick = { currentScreen.value = RutasItems.VeinteNoviembreValles }
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        CustomButtom(
            text = "Km 10 X Panteon",
            onClick = { currentScreen.value = RutasItems.Km10Panteon }
        )
    }
}
