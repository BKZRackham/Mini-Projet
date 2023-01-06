package fr.vinwin.miniprojet.backend

import com.google.common.truth.Truth.assertThat
import fr.vinwin.miniprojet.backend.EstimatorBackend
import fr.vinwin.miniprojet.backend.EstimatorBackendImpl
import org.junit.Before
import org.junit.Test

class EstimatorBackendUnitTest {

    lateinit var estimatorBackend : EstimatorBackend

    @Before
    fun initialize(){
        estimatorBackend = EstimatorBackendImpl()
    }

    @Test
    fun `Essai du modele`(){
        assertThat(estimatorBackend.estimate(64.0,4.0,400.0,1.070963,49.402764,1.0)).isLessThan(145000.0)
        assertThat(estimatorBackend.estimate(64.0,4.0,400.0,1.070963,49.402764,1.0)).isGreaterThan(143000.0)
    }

}