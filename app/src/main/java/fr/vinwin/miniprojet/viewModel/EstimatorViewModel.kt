package fr.vinwin.miniprojet.viewModel

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


    fun estimate ( carac1 : Float ,carac2 : Float, carac3 : Float){
        _estimationResult.value = estimatorBackend.estimate(carac1,carac2,carac3)
        Log.d("test", "essai  $_estimationResult")
    }
}