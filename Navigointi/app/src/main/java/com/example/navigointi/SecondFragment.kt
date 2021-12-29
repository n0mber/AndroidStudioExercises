package com.example.navigointi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import android.widget.RadioGroup
import androidx.navigation.fragment.findNavController
import com.example.navigointi.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    var radioGroup : RadioGroup? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        radioGroup = getView()?.findViewById<RadioGroup>(R.id.radioGroupAnswers)
        binding.buttonThird.setOnClickListener {
            val id = radioGroup!!.checkedRadioButtonId
            val radiobtn = radioGroup!!.findViewById<RadioButton>(id)
            val selection = radioGroup!!.indexOfChild(radiobtn)
            if(selection > -1) {
                findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToQuestion1(selection.toString()))

            }
        }

        /*binding.buttonThird.setOnClickListener {

            if (view.findViewById<RadioButton>(R.id.radioButtonA).isChecked) {
                findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToQuestion1("A")) //R.id.action_SecondFragment_to_question1)
            }
            if (view.findViewById<RadioButton>(R.id.radioButtonB).isChecked){
                findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToQuestion1("B")) //R.id.action_SecondFragment_to_question1)
            }
            if (view.findViewById<RadioButton>(R.id.radioButtonC).isChecked){
                findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToQuestion1("C")) //R.id.action_SecondFragment_to_question1)
            }
            else
                findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToQuestion1(""))

        }*/
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}