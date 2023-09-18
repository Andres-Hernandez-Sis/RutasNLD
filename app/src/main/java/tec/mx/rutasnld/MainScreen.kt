package tec.mx.rutasnld

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import tec.mx.rutasnld.navigation.BottomBarItems
import tec.mx.rutasnld.navigation.BottomNavGraph
import tec.mx.rutasnld.navigation.SplashScreen
import tec.mx.rutasnld.ui.components.BottomBar
import tec.mx.rutasnld.ui.components.CustomTopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val navController = rememberNavController()

    val navigationItems = listOf(
        BottomBarItems.Home,
        BottomBarItems.Rutas,
        BottomBarItems.Otros
    )
    Scaffold(
        topBar = {
            CustomTopBar(navController = navController, screens = navigationItems)
        },
        bottomBar = {
            BottomBar(navController = navController, screens = navigationItems)
        }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .then(Modifier.systemBarsPadding())) // Ayuda al contenido ajustarse al topbar.
        {
            BottomNavGraph(navController = navController)  // Contenido de la pantalla actual
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String?{
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}
