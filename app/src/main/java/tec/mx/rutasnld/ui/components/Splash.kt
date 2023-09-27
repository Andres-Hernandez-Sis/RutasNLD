package tec.mx.rutasnld.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import tec.mx.rutasnld.R

@Composable
fun Splash() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color(115, 12, 44)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "LogoSplash1",
            modifier = Modifier.fillMaxWidth().padding(40.dp)
        )
    }
}


