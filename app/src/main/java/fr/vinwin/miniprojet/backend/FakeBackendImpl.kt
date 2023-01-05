package fr.vinwin.miniprojet.backend

import javax.inject.Inject


class FakeBackendImpl @Inject constructor () : EstimatorBackend {



    override fun estimate  (carac1: Float, carac2: Float, carc3 : Float): Float {
        return (75000.55f)
    }
}