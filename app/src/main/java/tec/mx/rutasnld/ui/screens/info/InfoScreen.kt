package tec.mx.rutasnld.ui.screens.info

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun InfoScreen() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 8.dp
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            item {
                Text(
                    text = "Transporte Público en Nuevo Laredo",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Sistema de Autobuses Urbanos",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "El transporte público en Nuevo Laredo está operado por el Sistema de Autobuses Urbanos. Este sistema ofrece rutas que conectan diferentes áreas de la ciudad, permitiendo a los residentes y visitantes moverse de manera eficiente.",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    text = "Horarios y Tarifas",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Los horarios y tarifas del transporte público pueden variar. A continuación, te proporcionamos información general, pero te recomendamos verificar la información actualizada en el sitio web oficial del Sistema de Autobuses Urbanos de Nuevo Laredo o en las paradas de autobús.\n",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                )

                Text(
                    text = "Horarios 🕒: 7am a 8pm\n",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                )

                Text(
                    text = "Rutas al centro de la ciudad 🚍:\n" +
                            " - Tarifa pasajero normal: $9 Pesos\n" +
                            " - Tarifa pasajero estudiante: $6 Pesos\n",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                )

                Text(
                    text = "Rutas kilómetros 🚍:\n" +
                            " - Tarifa pasajero normal: \$10 Pesos\n" +
                            " - Tarifa pasajero estudiante: \$7 Pesos",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                )
            }
        }
    }
}
