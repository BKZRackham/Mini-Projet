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
        ortSession: OrtSession,
        ortEnvironment: OrtEnvironment
    ): Float {
        // Get the name of the input node
        val inputName = ortSession.inputNames?.iterator()?.next()
        // Make a FloatBuffer of the inputs
        val floatBufferInputs = FloatBuffer.wrap(
            floatArrayOf(
                surfaceR,
                nombreP,
                surfaceT,
                longitude,
                latitude,
                typeBien
            )
        )
        // Create input tensor with floatBufferInputs of shape ( 1 , 6 )
        val inputTensor =
            OnnxTensor.createTensor(ortEnvironment, floatBufferInputs, longArrayOf(1, 6))
        // Run the model
        val results = ortSession.run(mapOf(inputName to inputTensor))
        // Fetch and return the results
        val output = results[0].value as Array<FloatArray>
        Log.d("test", "valeur " + output[0][0])
        return (output[0][0])
    }
}

