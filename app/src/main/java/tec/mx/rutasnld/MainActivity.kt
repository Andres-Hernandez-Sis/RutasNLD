package tec.mx.rutasnld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tec.mx.rutasnld.ui.screens.mapeo.MapScreen
import tec.mx.rutasnld.ui.screens.rutas.RutaScreen
import tec.mx.rutasnld.ui.theme.RutasNLDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = MainViewModel()
        installSplashScreen().setKeepOnScreenCondition {
            viewModel.splashScreenLoading
        }
        viewModel.espera()
        setContent {
            RutasNLDTheme {
                setContent {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        MainScreen()
                    }
                }
            }
        }
    }
}
