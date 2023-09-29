package tec.mx.rutasnld.ui.screens.mapeo


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MapScreen() {
    val viewModel: MapViewModel = viewModel()
    viewModel.LeafletMap()
}

