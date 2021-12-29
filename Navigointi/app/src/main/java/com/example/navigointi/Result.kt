package com.example.navigointi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.navigation.fragment.findNavController
import com.example.navigointi.databinding.FragmentResultBinding
import kotlinx.coroutines.selects.select



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "UserAnswerQ5"


/**
 * A simple [Fragment] subclass.
 * Use the [Result.newInstance] factory method to
 * create an instance of this fragment.
 */
private val correctAnswers = arrayOf(2,1,2,2,0)

class Result : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var _binding: FragmentResultBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentResultBinding.inflate(inflater, container, false)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }

        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        printResult()

    }

    private fun printResult() {
        var correctAnswersTotal = 0
        for(i in 0..param1!!.length - 1){

            if(param1!![i].toString() == correctAnswers[i].toString()){
                correctAnswersTotal++
            }
        }
        println(correctAnswersTotal)
        var view = getView()?.findViewById<TextView>(R.id.resultsText)
        val msg = "You got " + correctAnswersTotal.toString() + "/" + correctAnswers.size.toString() + " correct!"
        view?.text = msg
    }




        companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Result.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Result().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)

                }
            }
    }
}