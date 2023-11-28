package tec.mx.rutasnld.ui.screens.mapeinteractivo

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import tec.mx.rutasnld.location.LocationViewModel
import tec.mx.rutasnld.network.NetworkViewModel
@SuppressLint("SetJavaScriptEnabled")
@Composable
fun LeafletMap(networkViewModel: NetworkViewModel) {
    // Verificar la conexión a Internet
    val context = LocalContext.current
    val isConnected = networkViewModel.isNetworkAvailable(context)
    lateinit var globalWebView: WebView

    // Define una variable de estado para rastrear si el mapa ha cargado
    var mapLoaded by remember { mutableStateOf(false) }

    Column{
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                WebView(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()
                    settings.javaScriptEnabled = true
                    if (isConnected) {
                        loadUrl("file:///android_asset/leaflet_map.html") // Ruta al archivo HTML de Leaflet
                    } else {
                        loadUrl("file:///android_asset/connection_error.html")
                        Toast.makeText(
                            context,
                            "Verifica la conexión a internet",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            },
            update = { webView ->
                globalWebView = webView
                // Añade un WebViewClient personalizado para detectar cuándo la página ha terminado de cargar
                webView.webViewClient = object : WebViewClient() {
                    override fun onPageFinished(view: WebView?, url: String?) {
                        mapLoaded = true
                        // Verifica si el mapa ha cargado y llama a JavaScript
                        if (mapLoaded) {
                            val locationViewModel = LocationViewModel()
                            if (locationViewModel.checkLocationPermission(context)) {
                                locationViewModel.getCurrentLocation(context) { lat, long ->
                                    webView.loadUrl("javascript:getLocationAndPassToJavaScript($lat, $long)")
                                }
                            }
                        }
                    }
                }
                // Llama a la función JavaScript para obtener la ubicación si el mapa ya ha cargado
                if (mapLoaded) {
                    val locationViewModel = LocationViewModel()
                    if (locationViewModel.checkLocationPermission(context)) {
                        locationViewModel.getCurrentLocation(context) { lat, long ->
                            webView.loadUrl("javascript:getLocationAndPassToJavaScript($lat, $long)")
                        }
                    }
                }
            }
        )
    }
}
