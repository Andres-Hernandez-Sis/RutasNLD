package tec.mx.rutasnld.ui.screens.ruta

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RutaScreen() {
    val viewModel: RutaViewModel = viewModel()
    Column {
        Text(text = "Menu de rutas")
    }
}

