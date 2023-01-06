package fr.vinwin.miniprojet.view

import ai.onnxruntime.OrtEnvironment
import ai.onnxruntime.OrtSession
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.view.ViewCompat.setBackground
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

    private fun createORTSession( ortEnvironment: OrtEnvironment) : OrtSession {
        val modelBytes = resources.openRawResource( R.raw.model_v1 ).readBytes()
        return ortEnvironment.createSession( modelBytes )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.root.background.alpha = 125

        val args : EstimationFragmentArgs by navArgs()
        val estimatorViewModel : EstimatorViewModel by viewModels()

        val ortEnvironment = OrtEnvironment.getEnvironment()
        val ortSession = createORTSession( ortEnvironment )
        estimatorViewModel.estimate(args.surfaceHabitable,args.numberRooms,args.surfaceTerrain,1.071855f,49.402764f, 1f, ortSession , ortEnvironment)

        estimatorViewModel.estimationResult.observe(viewLifecycleOwner){ value ->
            if(value <= 0f) {
                binding.estimationText.text = getString(R.string.estimation_error_text)

            }

            else if(value <= 200000f){
                binding.estimationText.text = getString(R.string.estimation_text, value)
                binding.root.background = context?.let { getDrawable(it,R.mipmap.ic_low_cost_foreground) }
            }

            else if(value <= 400000f){
                binding.estimationText.text = getString(R.string.estimation_text, value)
                binding.root.background = context?.let { getDrawable(it,R.mipmap.ic_mid_cost_foreground) }
            }

            else if(value > 600000f){
                binding.estimationText.text = getString(R.string.estimation_text, value)
                binding.root.background = context?.let { getDrawable(it,R.mipmap.ic_high_cost_foreground) }
            }
        }



    }
}