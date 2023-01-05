package fr.vinwin.miniprojet.backend

import ai.onnxruntime.OrtEnvironment
import ai.onnxruntime.OrtSession
import javax.inject.Inject


class FakeBackendImpl @Inject constructor () : EstimatorBackend {



    override fun estimate  (surfaceR : Float, nombreP: Float , surfaceT : Float , longitude : Float , latitude : Float , typeBien : Float , ortSession: OrtSession, ortEnvironment: OrtEnvironment): Float {
        return (75000.55f)
    }
}