package fr.vinwin.miniprojet.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import fr.vinwin.miniprojet.R
import fr.vinwin.miniprojet.databinding.CharacteristicsFragmentBinding
import fr.vinwin.miniprojet.viewModel.EstimatorViewModel

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

        binding.caracButton.setOnClickListener {
            try {
                val surfaceR = binding.editText1.text.toString().toFloatOrNull()
                val nombreP = binding.editText2.text.toString().toFloatOrNull()
                val surfaceT = binding.editText3.text.toString().toFloatOrNull()
                val longitude = binding.editText4.text.toString().toFloatOrNull()
                val latitude = binding.editText5.text.toString().toFloatOrNull()
                val typeBien = binding.editText6.text.toString().toFloatOrNull()

                if (surfaceR != null && nombreP != null && surfaceT != null && longitude != null && latitude != null && typeBien != null){
                    val action = CharacteristicsFragmentDirections.actionCharacteristicsFragmentToEstimationFragment(surfaceR,nombreP,surfaceT,longitude,latitude,typeBien)
                    findNavController().navigate(action)

                }
                else{
                    Toast.makeText( activity, "Veuillez remplir tous les champs" , Toast.LENGTH_LONG ).show()
                }
            }catch (e: java.lang.NumberFormatException){
                val action = CharacteristicsFragmentDirections.actionCharacteristicsFragmentToEstimationFragment(-1f,-1f,-1f,-1f,-1f,-1f)
                findNavController().navigate(action)
            }
        }
    }
}