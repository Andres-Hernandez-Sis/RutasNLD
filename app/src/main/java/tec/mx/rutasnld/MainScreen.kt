@file:OptIn(ExperimentalMaterial3Api::class)

package tec.mx.rutasnld

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val scaffolState = rememberScrollState()
    val scope = rememberCoroutineScope()

    val navigation_item = listOf(
        BottomBarItems.Home,
        BottomBarItems.Mapas,
        BottomBarItems.Otros
    )

    Scaffold(

    ) {

    }

}
