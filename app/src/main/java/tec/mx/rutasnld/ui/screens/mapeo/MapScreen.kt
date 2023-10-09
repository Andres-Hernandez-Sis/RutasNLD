package tec.mx.rutasnld.ui.screens.mapeo


import androidx.compose.runtime.Composable
import tec.mx.rutasnld.location.LocationViewModel
import tec.mx.rutasnld.location.ShowPersmissionAndLocation

@Composable
fun MapScreen(mapViewModel: MapViewModel) {
    mapViewModel.LeafletMap()
    ShowPersmissionAndLocation(viewModel = LocationViewModel())
}

