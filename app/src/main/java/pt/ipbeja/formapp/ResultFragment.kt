package pt.ipbeja.formapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import pt.ipbeja.formapp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding : FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        this.binding = FragmentResultBinding.inflate(inflater)

        this.binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // Inflate the layout for this fragment
        return binding.root
    }


}