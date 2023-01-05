package fr.vinwin.miniprojet.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import fr.vinwin.miniprojet.R
import fr.vinwin.miniprojet.databinding.EstimationFragmentBinding
import fr.vinwin.miniprojet.viewModel.EstimatorViewModel

@AndroidEntryPoint
class EstimationFragment : Fragment() {

    private lateinit var binding: EstimationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EstimationFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args : EstimationFragmentArgs by navArgs()
        val estimatorViewModel : EstimatorViewModel by viewModels()

        estimatorViewModel.estimate(args.surfaceHabitable,args.surfaceTerrain,args.numberRooms)

        estimatorViewModel.estimationResult.observe(viewLifecycleOwner){ value ->
            if(value <= 0f) {
                binding.estimationText.text = getString(R.string.estimation_error_text)

            }

            else if(value > 0f){
                binding.estimationText.text = getString(R.string.estimation_text, value)
            }
        }


    }
}