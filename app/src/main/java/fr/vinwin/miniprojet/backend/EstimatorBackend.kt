package fr.vinwin.miniprojet.backend

import ai.onnxruntime.OrtEnvironment
import ai.onnxruntime.OrtSession

interface EstimatorBackend {

    fun estimate(surfaceR : Float, nombreP: Float , surfaceT : Float , longitude : Float , latitude : Float , typeBien : Float) : Float
}