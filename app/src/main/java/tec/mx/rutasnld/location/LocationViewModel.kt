package tec.mx.rutasnld.location

import android.annotation.SuppressLint
import android.app.Application
import android.location.Location
import androidx.core.location.LocationManagerCompat.getCurrentLocation
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Timer
import java.util.TimerTask

//class LocationViewModel(application: Application) : AndroidViewModel(application) {
//
//    private val locationLiveData = MutableLiveData<Location?>()
//    val location: LiveData<Location?> = locationLiveData
//
//    init {
//        // Inicializa la ubicación cuando se crea el ViewModel
//        updateLocation()
//        // Actualiza la ubicación cada 30 segundos (ajusta el intervalo según tus necesidades)
//        val timer = Timer()
//        timer.scheduleAtFixedRate(object : TimerTask() {
//            override fun run() {
//                updateLocation()
//            }
//        }, 0, 30000)
//    }
//
//    @SuppressLint("MissingPermission")
//    private fun updateLocation() {
//        CoroutineScope(Dispatchers.IO).launch {
//            val location = getCurrentLocation(getApplication())
//            withContext(Dispatchers.Main) {
//                locationLiveData.value = location
//            }
//        }
//    }
//}
