package tec.mx.rutasnld.ui.screens.mapeo


import androidx.compose.runtime.Composable
import tec.mx.rutasnld.location.LocationViewModel
import tec.mx.rutasnld.location.ShowPermissionAndLocation
import tec.mx.rutasnld.network.NetworkViewModel

@Composable
fun MapScreen(networkViewModel: NetworkViewModel) {
    LeafletMap(networkViewModel)
    ShowPermissionAndLocation(viewModel = LocationViewModel())
}

