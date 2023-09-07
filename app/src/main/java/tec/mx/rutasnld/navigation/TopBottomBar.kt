package tec.mx.rutasnld.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(
    navController: NavHostController,
    screens: List<BottomBarItems>,
) {
    val currentRoute = CurrentRoute(navController)

    BottomNavigation(backgroundColor = Color(161,21,59,)) {
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

@Composable
fun CustomTopBar(navController: NavHostController, screens: List<BottomBarItems>) {
    val currentRoute = CurrentRoute(navController)
    val currentScreen = screens.find { it.route == currentRoute }
    TopAppBar(
        title = {
            Text(
                text = "RutasNLD 🚍 - " + currentScreen?.title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        },
        backgroundColor = Color(161,21,59,),
        contentColor = MaterialTheme.colors.onPrimary,
    )
}


@Composable
private fun CurrentRoute(navController: NavHostController): String?{
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}
