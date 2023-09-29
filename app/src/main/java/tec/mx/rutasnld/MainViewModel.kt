package tec.mx.rutasnld

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var splashScreenLoading by mutableStateOf(true)
        private set

    fun espera(){
        viewModelScope.launch {
            delay(2500)
            splashScreenLoading = false
        }
    }
}



