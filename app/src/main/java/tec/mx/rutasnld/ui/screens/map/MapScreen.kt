package tec.mx.rutasnld.ui.screens.map

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MapScreen() {
    val viewModel: MapViewModel = viewModel()
    LeafletMap()
}

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
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
                if (isConnected) {
                    loadUrl("file:///android_asset/leaflet_map.html") // Ruta al archivo HTML de Leaflet
                } else {
                    loadUrl("file:///android_asset/connection_error.html")
                    Toast.makeText(context, "Verifica la conexión a internet", Toast.LENGTH_LONG).show()
                }
            }
        },
        update = { webView ->
            webView.clearCache(true)
            //webView.clearHistory()
        }
    )
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