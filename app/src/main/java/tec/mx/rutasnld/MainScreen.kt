package tec.mx.rutasnld


import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold (bottomBar = {}) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val Screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Mapas,
        BottomBarScreen.Otros
    )
}