package tec.mx.rutasnld.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import tec.mx.rutasnld.R
import tec.mx.rutasnld.navigation.BottomBarItems

@Composable
fun CustomTopBar(
    navController: NavHostController,
    screens: List<BottomBarItems>,
) {
    val currentRoute = currentRoute(navController)
    val currentScreen = screens.find { it.route == currentRoute }

    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logot), // Reemplaza con el recurso de tu imagen
                    contentDescription = "Logo",
                    modifier = Modifier.size(30.dp),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "" + currentScreen?.title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            }
        },
        backgroundColor = Color(161, 21, 59),
        contentColor = MaterialTheme.colors.onPrimary,
    )
}
