package tec.mx.rutasnld.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CustomTopBar(title: String, onNavClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = title, style = MaterialTheme.typography.h2, color = Color.White) },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        navigationIcon = {
            IconButton(onClick = { onNavClick() }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu Button")
            }
        }
    )
}