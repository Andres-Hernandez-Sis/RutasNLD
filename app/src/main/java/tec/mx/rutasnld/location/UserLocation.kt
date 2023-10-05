package tec.mx.rutasnld.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
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
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices

@Composable
fun LocationScreen() {
    val context = LocalContext.current
    var location by remember { mutableStateOf("Ubicación desconocida") }

    // Create a permission launcher
    val requestPermissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission(),
            onResult = { isGranted: Boolean ->
                if (isGranted) {
                    // Permission granted, update the location
                    getCurrentLocation(context) { lat, long ->
                        location = "Lat: $lat, Lgt: $long"
                    }
                }
            })

    val hasLocationPermission = checkLocationPermission(context)

    if (!hasLocationPermission) {
        // Si no se ha otorgado el permiso, solicitarlo directamente
        LaunchedEffect(hasLocationPermission) {
            requestPermissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }
    } else {
        // Si ya se otorgó el permiso, obtener la ubicación actual
        getCurrentLocation(context) { lat, long ->
            location = "Lat: $lat, Lgt: $long"
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Mostrar las coordenadas en la esquina inferior izquierda
        Text(
            text = location,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(2.dp)
        )
    }
}

private fun checkLocationPermission(context: Context): Boolean {
    return ContextCompat.checkSelfPermission(
        context,
        android.Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
}


private fun getCurrentLocation(context: Context, callback: (Double, Double) -> Unit) {
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    if (ActivityCompat.checkSelfPermission(
            context, // Utiliza el contexto proporcionado
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            context, // Utiliza el contexto proporcionado
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        // TODO: Consider calling
        //    ActivityCompat#requestPermissions
        // aquí para solicitar los permisos que faltan y manejar la respuesta en la actividad.
        return
    }
    fusedLocationClient.lastLocation
        .addOnSuccessListener { location ->
            if (location != null) {
                val lat = location.latitude
                val long = location.longitude
                callback(lat, long)
            }
        }
        .addOnFailureListener { exception ->
            // Maneja el error de obtención de ubicación
            exception.printStackTrace()
        }
}
