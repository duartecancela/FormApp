package pt.ipbeja.formapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentResultOwner
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import pt.ipbeja.formapp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding : FragmentResultBinding
    private val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val personName = args.personName
        val nationality = args.nationality
        val distance = args.distance
        val date = args.date

        this.binding = FragmentResultBinding.inflate(inflater)

        this.binding.textViewPersonName.text = personName
        this.binding.textViewNationality.text = nationality
        this.binding.textViewDistance.text = distance.toString()
        this.binding.textViewDate.text = date.toString()

        this.binding.buttonBack.setOnClickListener {
            findNavController().popBackStack(R.id.startFragment, false)
        }

        // Inflate the layout for this fragment
        return binding.root
    }


}