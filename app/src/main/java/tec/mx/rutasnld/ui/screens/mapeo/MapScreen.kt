package tec.mx.rutasnld.ui.screens.mapeo


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import tec.mx.rutasnld.location.LocationScreen

@Composable
fun MapScreen() {
    val viewModel: MapViewModel = viewModel()
    viewModel.LeafletMap()
    LocationScreen()
}

