package fr.vinwin.miniprojet.viewModel

import ai.onnxruntime.OrtEnvironment
import ai.onnxruntime.OrtSession
import android.util.Log
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

    private val _estimationResult: MutableLiveData<Float> = state.getLiveData(STATE_KEY_RESULT, 0f)
    val estimationResult: LiveData<Float> = _estimationResult


    fun estimate (surfaceR : Float, nombreP: Float , sufaceT : Float , longitude : Float , latitude : Float , typeBien : Float , ortSession: OrtSession, ortEnvironment: OrtEnvironment){
        _estimationResult.value = estimatorBackend.estimate(surfaceR,nombreP,sufaceT,longitude,latitude,typeBien, ortSession, ortEnvironment)
        Log.d("test", "essai  $estimationResult")
    }
}