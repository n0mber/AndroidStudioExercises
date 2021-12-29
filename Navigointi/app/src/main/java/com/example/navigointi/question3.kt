package com.example.navigointi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.navigation.fragment.findNavController
import com.example.navigointi.databinding.FragmentQuestion3Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "UserAnswerQ2"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [question3.newInstance] factory method to
 * create an instance of this fragment.
 */
class question3 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentQuestion3Binding? = null
    var radioGroup : RadioGroup? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        _binding = FragmentQuestion3Binding.inflate(inflater, container, false)
        return binding.root
        //return inflater.inflate(R.layout.fragment_question1, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //view.findViewById<TextView>(R.id.textView).text = param1

        radioGroup = getView()?.findViewById<RadioGroup>(R.id.radioGroupAnswers)
        binding.buttonSecond3.setOnClickListener {
            val id = radioGroup!!.checkedRadioButtonId
            val radiobtn = radioGroup!!.findViewById<RadioButton>(id)
            val selection = radioGroup!!.indexOfChild(radiobtn)
            val ans = param1 + selection.toString()
            if (selection > -1) {
                findNavController().navigate(
                    question3Directions.actionQuestion3ToQuestion4(ans.toString()
                    )
                )


            }

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment question3.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            question3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}