package fr.vinwin.miniprojet.backend

import javax.inject.Inject


class FakeBackendImpl @Inject constructor () : EstimatorBackend {



    //Fonction fake qui remplace le backend en cas de problème
    override fun estimate  (surfaceR : Double, nombreP: Double , surfaceT : Double , longitude : Double , latitude : Double , typeBien : Double): Double {
        return (75000.55)
    }
}