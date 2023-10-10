package tec.mx.rutasnld.ui.screens.mapeo


import androidx.compose.runtime.Composable
import tec.mx.rutasnld.location.LocationViewModel
import tec.mx.rutasnld.location.ShowPermissionAndLocation

@Composable
fun MapScreen(mapViewModel: MapViewModel) {
    mapViewModel.LeafletMap()
    ShowPermissionAndLocation(viewModel = LocationViewModel())
}

