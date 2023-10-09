package tec.mx.rutasnld.ui.screens.rutas

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun RutaScreen(navController: NavHostController) {

    //val viewModel : RutaViewModel = viewModel()

    val navController = rememberNavController()
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Menú de Rutas 🚍",
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
        }

        // Apartado: Camiones que pasan por el centro de la ciudad
        item {
            Text(
                text = "Camiones Centricos",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
        }

        item {
            CustomizableList(
                title = "Mirador Panteon",
                buttonText = "Abrir Mapa",
                onButtonClick = {
                    navController.navigate(NavRoutes.ROUTE_RUTA_MIRADOR_PANTEON)
                }
            )
        }

        // Apartado: Camiones que pasan por las afueras de la ciudad
        item {
            Text(
                text = "Camiones Centricos - Afueras",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
        }

        item {
            CustomizableList(
                title = "Mina Voluntad",
                buttonText = "Abrir Mapa",
                onButtonClick = {
                    ///
                }
            )
        }
    }

}
@Composable
fun CustomizableList(
    title: String,
    buttonText: String,
    onButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Button(
            onClick = { onButtonClick() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = buttonText)
        }
    }
}


@Composable
fun RutaMiradorPanteon() {
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
                loadUrl("file:///android_asset/MiradorPanteon.html") // Ruta al archivo HTML de Leaflet
            }
        }
    )
}


object NavRoutes {
    const val ROUTE_RUTA_SCREEN = "ruta_screen"
    const val ROUTE_RUTA_MIRADOR_PANTEON = "ruta_mirador_panteon"
}

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.ROUTE_RUTA_SCREEN
    ) {
        composable(NavRoutes.ROUTE_RUTA_SCREEN) {
            RutaScreen(navController)
        }
        composable(NavRoutes.ROUTE_RUTA_MIRADOR_PANTEON) {
            RutaMiradorPanteon()
        }
    }
}