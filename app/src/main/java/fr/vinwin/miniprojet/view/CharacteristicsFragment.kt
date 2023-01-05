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

        val estimatorViewModel : EstimatorViewModel by viewModels()


        binding.caracButton.setOnClickListener {
            try {
                val surfaceR = binding.editText1.text.toString().toFloatOrNull()
                val nombreP = binding.editText2.text.toString().toFloatOrNull()
                val surfaceT = binding.editText3.text.toString().toFloatOrNull()
                val typeBien = binding.editText4.text.toString().toFloatOrNull()

                if (surfaceR != null && nombreP != null && surfaceT != null && typeBien != null){
                    val action = CharacteristicsFragmentDirections.actionCharacteristicsFragmentToEstimationFragment(surfaceR,nombreP,surfaceT,typeBien)
                    findNavController().navigate(action)
                }
                else{
                    Toast.makeText( activity, "Veuillez remplir tous les champs" , Toast.LENGTH_LONG ).show()
                }
            }catch (e: java.lang.NumberFormatException){
                val carac1 = -1.0f
                val carac2 = -1.0f
                val carac3 = -1.0f
                val carac4 = -1.0f
                val action = CharacteristicsFragmentDirections.actionCharacteristicsFragmentToEstimationFragment(carac1,carac2,carac3,carac4)
                findNavController().navigate(action)
            }
        }
    }
}