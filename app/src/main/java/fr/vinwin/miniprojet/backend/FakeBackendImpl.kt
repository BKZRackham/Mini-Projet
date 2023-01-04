package fr.vinwin.miniprojet.backend

import javax.inject.Inject


class FakeBackendImpl @Inject constructor () : EstimatorBackend {



    override fun estimate  (carac1: Double, carac2: Double): Double {
        return (75000.55)
    }
}