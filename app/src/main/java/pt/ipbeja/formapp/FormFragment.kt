package pt.ipbeja.formapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import pt.ipbeja.formapp.databinding.FragmentFormBinding

class FormFragment : Fragment() {

    private lateinit var binding : FragmentFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        this.binding = FragmentFormBinding.inflate(inflater)

        this.binding.buttonResult.setOnClickListener {
            findNavController().navigate(FormFragmentDirections.actionFormFragmentToResultFragment())
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}