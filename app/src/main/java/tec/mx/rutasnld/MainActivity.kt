package tec.mx.rutasnld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import tec.mx.rutasnld.location.LocationScreen
//import tec.mx.rutasnld.location.LocationViewModel
import tec.mx.rutasnld.ui.screens.MainScreen
import tec.mx.rutasnld.ui.screens.mapeo.MapViewModel
import tec.mx.rutasnld.ui.theme.RutasNLDTheme

class MainActivity : ComponentActivity() {

    //private lateinit var locationViewModel: LocationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = MainViewModel()
        installSplashScreen().setKeepOnScreenCondition {
            viewModel.splashScreenLoading
        }
        viewModel.espera()

//        locationViewModel = ViewModelProvider(this).get(LocationViewModel::class.java)
//
//        setContent {
//            LocationScreen(locationViewModel = locationViewModel)
//        }

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
