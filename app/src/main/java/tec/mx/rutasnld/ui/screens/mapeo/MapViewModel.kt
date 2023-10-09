package tec.mx.rutasnld.ui.screens.mapeo

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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.ViewModel


class MapViewModel : ViewModel() {


    @Composable
    fun LeafletMap() {

        val infoDialog = remember { mutableStateOf(false) }

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

                    addJavascriptInterface(WebAppInterface(context,infoDialog), "Mensaje")
                    //addJavascriptInterface(WebInterface(), "Enviar Ubicacion")

                    if (isConnected) {
                        loadUrl("file:///android_asset/leaflet_map.html") // Ruta al archivo HTML de Leaflet
                    } else {
                        loadUrl("file:///android_asset/connection_error.html")
                        Toast.makeText(context, "Verifica la conexión a internet", Toast.LENGTH_LONG).show()
                    }
                }

            },
            update = { webView ->  // Asigna la referencia del WebView una vez que está creado
                webView.clearCache(true)
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
}





class WebAppInterface(private val mContext: Context, private val infoDialog: MutableState<Boolean>) {
    @JavascriptInterface
    fun showToast(toast: String) {
        infoDialog.value = true
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
    }
}



