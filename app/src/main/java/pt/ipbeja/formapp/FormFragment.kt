package pt.ipbeja.formapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.get
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.NonDisposableHandle.parent
import pt.ipbeja.formapp.databinding.FragmentFormBinding
import kotlin.math.absoluteValue

class FormFragment : Fragment() {

    private lateinit var binding : FragmentFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        this.binding = FragmentFormBinding.inflate(inflater)

        val name = this.binding.editTextPersonName.text
        var nationality : String? = null

        // Create an ArrayAdapter using the string array and a default spinner layout
        this.activity?.let {
            ArrayAdapter.createFromResource(
                it.applicationContext,
                R.array.nationality,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                this.binding.spinnerNationality.adapter = adapter
            }
        }

        // when spinner is selected
        this.binding.spinnerNationality.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                nationality = binding.spinnerNationality.getItemAtPosition(p2).toString()
                Toast.makeText(activity,nationality, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        this.binding.buttonResult.setOnClickListener {
            findNavController()
                .navigate(FormFragmentDirections
                    .actionFormFragmentToResultFragment(name.toString(), nationality.toString()))
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}