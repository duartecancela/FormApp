package pt.ipbeja.formapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import pt.ipbeja.formapp.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private lateinit var binding : FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        this.binding = FragmentStartBinding.inflate(inflater)

        this.binding.buttonStart.setOnClickListener {
            findNavController().navigate(StartFragmentDirections.actionStartFragmentToFormFragment())
        }

        // Inflate the layout for this fragment
        return binding.root


    }


}