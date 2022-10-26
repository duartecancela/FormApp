package pt.ipbeja.formapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pt.ipbeja.formapp.databinding.FragmentFormBinding
import java.util.*

class FormFragment : Fragment() {

    private lateinit var binding : FragmentFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        this.binding = FragmentFormBinding.inflate(inflater)

        with(binding.numberPickerDistance) {
            minValue = 0
            maxValue = 5000
        }

        val datePicker = this.binding.datePicker
        val day = datePicker.dayOfMonth
        val month = datePicker.month + 1
        val year = datePicker.year

        this.binding.buttonResult.setOnClickListener {

            val personName = this.binding.editTextPersonName.text
            val nationality = binding.spinnerNationality.selectedItem as String
            val distance = binding.numberPickerDistance.value

            val date = Calendar.getInstance().run {
                set(Calendar.DAY_OF_MONTH, binding.datePicker.dayOfMonth)
                set(Calendar.MONTH, binding.datePicker.month)
                set(Calendar.YEAR, binding.datePicker.year)
                time
            }

            findNavController()
                .navigate(FormFragmentDirections
                    .actionFormFragmentToResultFragment(personName.toString(), nationality, distance))
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}