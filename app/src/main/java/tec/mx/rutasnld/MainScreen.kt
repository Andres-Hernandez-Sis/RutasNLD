package tec.mx.rutasnld

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import tec.mx.rutasnld.navigation.BottomBarItems
import tec.mx.rutasnld.navigation.BottomBar
import tec.mx.rutasnld.navigation.BottomNavGraph
import tec.mx.rutasnld.navigation.CustomTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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
        Column()
        {
            Spacer(modifier = Modifier.height(50.dp)) // Espacio entre el TopAppBar y el contenido
            BottomNavGraph(navController = navController)  // Contenido de la pantalla actual
        }
    }
}