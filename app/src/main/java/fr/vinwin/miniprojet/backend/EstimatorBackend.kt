package fr.vinwin.miniprojet.backend



interface EstimatorBackend {
    fun estimate(surfaceR : Double, nombreP: Double , surfaceT : Double , longitude : Double , latitude : Double , typeBien : Double) : Double

}