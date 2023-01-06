package fr.vinwin.miniprojet.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.vinwin.miniprojet.backend.EstimatorBackend
import javax.inject.Inject


private const val STATE_KEY_RESULT = "state_key_result"

@HiltViewModel
class EstimatorViewModel @Inject constructor(state : SavedStateHandle, private val estimatorBackend: EstimatorBackend): ViewModel(){

    //On créer la LiveData de manière à conserver la donnée resultat
    private val _estimationResult: MutableLiveData<Double> = state.getLiveData(STATE_KEY_RESULT, 0.0)
    val estimationResult: LiveData<Double> = _estimationResult


    //Appel de la fonction du backend
    fun estimate (surfaceR : Double, nombreP: Double , sufaceT : Double , longitude : Double , latitude : Double , typeBien : Double){
        _estimationResult.value = estimatorBackend.estimate(surfaceR,nombreP,sufaceT,longitude,latitude,typeBien)

    }
}