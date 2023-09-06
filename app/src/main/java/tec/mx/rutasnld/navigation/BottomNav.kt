package tec.mx.rutasnld.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import tec.mx.rutasnld.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav(){
    val navController = rememberNavController()

    val navigationItems = listOf(
        BottomBarItems.Home,
        BottomBarItems.Rutas,
        BottomBarItems.Otros
    )

    Scaffold(
        bottomBar = {
            BarraNavegacion(navController = navController, screens = navigationItems)
        })
    {
       BottomNavGraph(navController = navController)
    }
}

@Composable
fun BarraNavegacion(
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
private fun CurrentRoute(navController: NavHostController): String?{
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun BottomNav(){
//    val navController = rememberNavController()
//    Scaffold(
//        bottomBar = {
//            BottomBar(navController = navController)
//        })
//    {
//       BottomNavGraph(navController = navController)
//    }
//}

//@Composable
//fun BottomBar(navController: NavHostController){
//    val screens = listOf(
//        BottomBarItems.Home,
//        BottomBarItems.Rutas,
//        BottomBarItems.Otros
//    )
//
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentDestination = navBackStackEntry?.destination
//
//     Row (
//         modifier = Modifier
//             .background(Color.Red)
//             .fillMaxWidth(),
//         horizontalArrangement = Arrangement.SpaceBetween,
//         verticalAlignment = Alignment.CenterVertically
//
//     ){
//         screens.forEach {Screen ->
//             AddItem(screen = Screen, currentDestination = currentDestination, navController = navController)
//         }
//     }
//
//}
//
//@Composable
//fun RowScope.AddItem(
//    screen: BottomBarItems,
//    currentDestination: NavDestination?,
//    navController: NavHostController
//){
//    val selected = currentDestination?.hierarchy?.any(){it.route == screen.route } == true
//
// //   val background =  if (selected) R.color.lightRed else Color.Red
//
//    val contentColor = if (selected) Color.White else Color.Red
//
//    Box(
//        modifier = Modifier
//            .height(220.dp)
//            .background(Color.Transparent)
//            .clickable(onClick = {
//                navController.navigate(screen.route) {
//                    popUpTo(navController.graph.findStartDestination().id)
//                    launchSingleTop = true
//                }
//            })
//    ){
//        Row (
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.spacedBy(4.dp)
//
//        ){
//            AnimatedVisibility(visible = selected) {
//                Text(text = screen.title, color = contentColor)
//            }
//        }
//    }
//}

