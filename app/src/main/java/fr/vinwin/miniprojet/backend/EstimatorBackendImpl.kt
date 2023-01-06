package fr.vinwin.miniprojet.backend

import ai.onnxruntime.OnnxTensor
import ai.onnxruntime.OrtEnvironment
import ai.onnxruntime.OrtSession
import android.util.Log
import fr.vinwin.miniprojet.R
import java.nio.FloatBuffer
import javax.inject.Inject

class EstimatorBackendImpl @Inject constructor() : EstimatorBackend {


    override fun estimate(
        surfaceR: Float,
        nombreP: Float,
        surfaceT: Float,
        longitude: Float,
        latitude: Float,
        typeBien: Float,
    ): Float {
       return(1258*surfaceR - 3984*nombreP + 55*surfaceT +  364721*longitude +
               885572*latitude +  1517842*typeBien -76242838)
    }
}

