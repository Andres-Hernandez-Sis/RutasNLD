package tec.mx.rutasnld.location

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun ShowPersmissionAndLocation(viewModel: LocationViewModel) {
    val context = LocalContext.current
    var location by remember { mutableStateOf("Ubicación desconocida") }

    // Create a permission launcher
    val requestPermissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission(),
            onResult = { isGranted: Boolean ->
                if (isGranted) {
                    // Permission granted, update the location
                    viewModel.getCurrentLocation(context) { lat, long ->
                        location = "Lat: $lat, Lgt: $long"
                    }
                }
            })

    val hasLocationPermission = viewModel.checkLocationPermission(context)

    if (!hasLocationPermission) {
        // Si no se ha otorgado el permiso, solicitarlo directamente
        LaunchedEffect(hasLocationPermission) {
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    } else {
        // Si ya se otorgó el permiso, obtener la ubicación actual
        viewModel.getCurrentLocation(context) { lat, long ->
            location = "Lat: $lat, Lgt: $long"
        }
    }

    // Mostrar las coordenadas en la esquina inferior izquierda
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = location,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(2.dp)
        )
    }

}

