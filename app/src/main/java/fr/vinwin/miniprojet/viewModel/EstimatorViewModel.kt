package fr.vinwin.miniprojet.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.vinwin.miniprojet.backend.EstimatorBackend
import javax.inject.Inject


@HiltViewModel
class EstimatorViewModel @Inject constructor(state : SavedStateHandle, private val estimatorBackend: EstimatorBackend): ViewModel(){



}