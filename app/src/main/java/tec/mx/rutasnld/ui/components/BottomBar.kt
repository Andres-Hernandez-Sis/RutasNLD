package tec.mx.rutasnld.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import tec.mx.rutasnld.navigation.BottomBarItems

@Composable
fun BottomBar(
    navController: NavHostController,
    screens: List<BottomBarItems>,
) {
    val currentRoute = currentRoute(navController)
    BottomNavigation(
        backgroundColor = Color(161,21,59)
    )
    {
        screens.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Image(
                        painter = painterResource(screen.icon),
                        contentDescription = screen.title,
                        modifier = Modifier
                            .size(30.dp)
                    )
                },
                label = { Text(text = screen.title, color = Color.White) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                alwaysShowLabel = false,
            )
        }
    }
}




