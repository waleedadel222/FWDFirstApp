package com.waleed.fwdfirstapp.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.waleed.fwdfirstapp.databinding.FragmentOnBoardingBinding


class OnBoardingFragment : Fragment() {

    private lateinit var onBoardingBinding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        -----first way to inflate the xml layout ---
//        onBoardingBinding = FragmentOnBoardingBinding.inflate(
//            inflater, R.layout.fragment_on_boarding, container, false
//        )

//        -----second way to inflate the xml layout ---
//        ---- more concise way----

        onBoardingBinding = FragmentOnBoardingBinding.inflate(inflater, container, false)


        onBoardingBinding.instructButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(OnBoardingFragmentDirections.actionWelcomeFragmentToInstructionsFragment())

        }


        return onBoardingBinding.root
    }


}