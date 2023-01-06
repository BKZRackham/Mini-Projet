package fr.vinwin.miniprojet.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import fr.vinwin.miniprojet.databinding.CharacteristicsFragmentBinding

@AndroidEntryPoint
class CharacteristicsFragment : Fragment() {

    private lateinit var binding: CharacteristicsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CharacteristicsFragmentBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //On attend le click du boutton pour chercher les valeurs des editText
        binding.caracButton.setOnClickListener {
            try {
                val surfaceR = binding.editText1.text.toString().toDoubleOrNull()
                val nombreP = binding.editText2.text.toString().toDoubleOrNull()
                val surfaceT = binding.editText3.text.toString().toDoubleOrNull()
                val longitude = binding.editText4.text.toString().toDoubleOrNull()
                val latitude = binding.editText5.text.toString().toDoubleOrNull()
                val typeBien = binding.editText6.text.toString().toDoubleOrNull()

                //Test des valeurs pour s'assurer que les champs soient remplis
                if (surfaceR != null && nombreP != null && surfaceT != null && longitude != null && latitude != null && typeBien != null){
                    val action = CharacteristicsFragmentDirections.actionCharacteristicsFragmentToEstimationFragment(surfaceR,nombreP,surfaceT,longitude,latitude,typeBien)
                    findNavController().navigate(action)

                }
                //Message d'erreur si tous les champs ne sont pas remplis
                else{
                    Toast.makeText( activity, "Veuillez remplir tous les champs" , Toast.LENGTH_LONG ).show()
                }
            }catch (e: java.lang.NumberFormatException){
                val action = CharacteristicsFragmentDirections.actionCharacteristicsFragmentToEstimationFragment(-1.0,-1.0,-1.0,-1.0,-1.0,-1.0)
                findNavController().navigate(action)
            }
        }
    }
}