package fr.vinwin.miniprojet.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


        binding.caracText1.text = getString(R.string.carac1_text)
        binding.caracText2.text = getString(R.string.carac2_text)
        binding.caracText3.text = getString(R.string.carac3_text)
        binding.caracText4.text = getString(R.string.carac4_text)

        binding.caracButton.setOnClickListener {
            try {
                val carac1 = binding.editText1.toString().toFloat()
                val carac2 = binding.editText2.toString().toFloat()
                val carac3 = binding.editText3.toString().toFloat()
                val carac4 = binding.editText4.toString().toFloat()
                val action = CharacteristicsFragmentDirections.actionCharacteristicsFragmentToEstimationFragment(carac1,carac2,carac3,carac4)
                findNavController().navigate(action)
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