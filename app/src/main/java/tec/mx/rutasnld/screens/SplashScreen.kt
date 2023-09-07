package tec.mx.rutasnld.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import tec.mx.rutasnld.R
import tec.mx.rutasnld.navigation.BottomBarItems

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(key1 = true) {
        delay(1500)
        navController.popBackStack() //Para borrar el registro de navegacion, sirve para que no se pueda ir de nuevo hacia atras < o
        navController.navigate(route = BottomBarItems.Home.route)
    }
    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Rutas NLD", fontSize = 30.sp, modifier = Modifier.padding(bottom = 20.dp),style = MaterialTheme.typography.h2)
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "LogoSplash",
            modifier = Modifier.size(150.dp, 150.dp).clip(shape = RoundedCornerShape(75.dp)),
        )
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "Powered by Android",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Green,
            style = MaterialTheme.typography.h2
        )
    }
}