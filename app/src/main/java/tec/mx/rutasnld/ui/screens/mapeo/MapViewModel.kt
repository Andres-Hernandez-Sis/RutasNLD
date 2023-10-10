package tec.mx.rutasnld.ui.screens.mapeo

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.ViewModel
import tec.mx.rutasnld.location.LocationViewModel


class MapViewModel : ViewModel() {

    @SuppressLint("StaticFieldLeak")
    private lateinit var webView: WebView


    @Composable
    fun LeafletMap() {

        // Verificar la conexión a Internet
        val context = LocalContext.current
        val isConnected = isNetworkAvailable(context)

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
            update = { webView ->  // Asigna la referencia del WebView una vez que está creado
                webView.clearCache(true)
            }
        )

        fun getLocationAndPassToJavaScript(context: Context, callback: (Double, Double) -> Unit) {
            val locationViewModel = LocationViewModel()
            val context = context
            if (locationViewModel.checkLocationPermission(context)) {
                locationViewModel.getCurrentLocation(context) { lat, long ->
                    if (lat != null && long != null) {
                        val javascriptCode = "updateLocation($lat, $long)"
                        webView.post { webView.evaluateJavascript(javascriptCode, null) }
                    }
                }
            }
        }

        //Prueba (abajo)
//        fun getLocationAndPassToJavaScript(callback: (Double, Double) -> Unit) {
//                // En lugar de obtener la ubicación actual, usa coordenadas de prueba
//                val latTest =  27.480623
//                val longTest = -99.5371145
//                callback(latTest, longTest) // Llama al callback con las coordenadas de prueba
//
//                // También puedes enviar las coordenadas a JavaScript si es necesario
//                val javascriptCode = "updateLocation($latTest, $longTest)"
//                webView.post { webView.evaluateJavascript(javascriptCode, null) }
//        }


    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val nw = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }
}

