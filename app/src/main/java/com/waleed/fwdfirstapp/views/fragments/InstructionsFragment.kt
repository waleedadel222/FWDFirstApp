package com.waleed.fwdfirstapp.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.waleed.fwdfirstapp.R
import com.waleed.fwdfirstapp.databinding.FragmentInstructionsBinding


class InstructionsFragment : Fragment() {

    private lateinit var instructionsBinding: FragmentInstructionsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        instructionsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instructions, container, false
        )
        instructionsBinding.doneInstructionButton.setOnClickListener { view: View ->
         view.findNavController()
                .navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoesFragment())
        }


        return instructionsBinding.root
    }


}