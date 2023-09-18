package tec.mx.rutasnld.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import tec.mx.rutasnld.R

@Composable
fun Splash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "LogoSplash",
            modifier = Modifier.fillMaxWidth().padding(40.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.logogob),
            contentDescription = "LogoSplash",
            modifier = Modifier.fillMaxWidth().padding(60.dp, 10.dp)
        )
    }
}