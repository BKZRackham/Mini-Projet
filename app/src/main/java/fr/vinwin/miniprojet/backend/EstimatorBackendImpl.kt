package fr.vinwin.miniprojet.backend


import javax.inject.Inject

class EstimatorBackendImpl @Inject constructor() : EstimatorBackend {


    //Fonction reprenant les coefficients du modèle obtenu pour estimer une valeur du bien
    override fun estimate(
        surfaceR: Double,
        nombreP: Double,
        surfaceT: Double,
        longitude: Double,
        latitude: Double,
        typeBien: Double,
    ): Double {
       return(1168.10676*surfaceR - 808.305528*nombreP + 69.8293278*surfaceT +  885518.746*longitude +
               1434223.84*latitude +  385518.416*typeBien -72143646.00108068)
    }
}


