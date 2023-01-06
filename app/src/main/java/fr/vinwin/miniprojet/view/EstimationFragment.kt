package fr.vinwin.miniprojet.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
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


        //Récupération des arguments par navigation
        val args : EstimationFragmentArgs by navArgs()
        val estimatorViewModel : EstimatorViewModel by viewModels()

        //On appelle le viewModel pour remplir la LiveData grâce au backend
        estimatorViewModel.estimate(args.surfaceHabitable,args.numberRooms,args.surfaceTerrain,args.longitude,args.latitude, args.typeBien)


        //On observe la LiveData du ViewModel
        estimatorViewModel.estimationResult.observe(viewLifecycleOwner){ value ->

            //On vérifie que la valeur est positive sinon on a une erreur
            if(value <= 0) {
                binding.estimationText.text = getString(R.string.estimation_error_text)
            }

            //Puis on adapte le background en fonction du prix
            else if(value <= 150000){
                binding.estimationText.text = getString(R.string.estimation_text, value)
                binding.root.background = context?.let { getDrawable(it,R.mipmap.ic_low_cost_foreground) }
                binding.root.background.alpha = 210
            }

            else if(value <= 250000){
                binding.estimationText.text = getString(R.string.estimation_text, value)
                binding.root.background = context?.let { getDrawable(it,R.mipmap.ic_mid_cost_foreground) }
                binding.root.background.alpha = 210
            }

            else if(value > 250000){
                binding.estimationText.text = getString(R.string.estimation_text, value)
                binding.root.background = context?.let { getDrawable(it,R.mipmap.ic_high_cost_foreground) }
                binding.root.background.alpha = 210
            }
        }



    }
}