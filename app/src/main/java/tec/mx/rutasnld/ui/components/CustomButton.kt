package tec.mx.rutasnld.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(text: String, onClick: () -> Unit) {

    val colorMap = mapOf(
        '2' to Color(156, 28, 53),
        'C' to Color(184, 153, 125, 255),
        'K' to Color(156, 28, 53),
        'L' to Color(184, 153, 125, 255),
        'M' to Color(156, 28, 53),
        'N' to Color(184, 153, 125, 255),
        'O' to Color(156, 28, 53),
        'P' to Color(184, 153, 125, 255),
        'R' to Color(156, 28, 53),
        'U' to Color(184, 153, 125, 255),
        'V' to Color(156, 28, 53)
    )


    val defaultColor = Color(103, 58, 183, 255) // Color vino (usado si la letra no está en el mapa)
    val buttonColor = if (text.isNotBlank()) {
        val firstLetter = text[0].uppercaseChar()
        colorMap[firstLetter] ?: defaultColor
    } else {
        defaultColor
    }

    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)
            .padding(horizontal = 10.dp),
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp, pressedElevation = 0.dp),
        shape = RoundedCornerShape(15.dp), // Puedes ajustar el radio según tus preferencias
        colors = ButtonDefaults.buttonColors(
            backgroundColor = buttonColor,
            contentColor = Color.White
        )
    ) {
        Text(text = text)
    }
}

