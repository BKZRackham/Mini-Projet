package fr.vinwin.miniprojet.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.google.common.truth.Truth.assertThat
import fr.vinwin.miniprojet.backend.EstimatorBackend

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ViewModelUnitTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var estimatorBackend: EstimatorBackend

    @Test
    fun `estimate() is called once and returns the calculated price in the livedata`(){
        val savedStateHandle = SavedStateHandle()
        Mockito.`when`(estimatorBackend.estimate(100.0,2.0,100.0,1.0,1.0,1.0)).thenReturn(150000.0)
        val estimatorViewModel = EstimatorViewModel(savedStateHandle, estimatorBackend)

        estimatorViewModel.estimate(100.0,2.0,100.0,1.0,1.0,1.0)
        Mockito.verify(estimatorBackend, Mockito.times(1)).estimate(100.0,2.0,100.0,1.0,1.0,1.0)
        assertThat(estimatorViewModel.estimationResult.value).isEqualTo(150000.0)


    }
}