package com.waleed.fwdfirstapp.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.waleed.fwdfirstapp.R
import com.waleed.fwdfirstapp.databinding.FragmentShoesDetailsBinding
import com.waleed.fwdfirstapp.models.Shoe
import com.waleed.fwdfirstapp.viewmodels.ShoesViewModel

class ShoesDetailsFragment : Fragment() {

    private lateinit var shoesDetailsBinding: FragmentShoesDetailsBinding

     private lateinit var shoesViewModel: ShoesViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        shoesDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoes_details, container, false
        )

        shoesDetailsBinding.shoe =
            Shoe("template name", "22", "template company", "some description about the shoe")

        shoesViewModel = ViewModelProvider(requireActivity())[ShoesViewModel::class.java]

        shoesDetailsBinding.saveButton.setOnClickListener {

            val bindingData = shoesDetailsBinding.shoe
            val name = bindingData?.name.toString()
            val size = bindingData?.size.toString()
            val company = bindingData?.company.toString()
            val description = bindingData?.description.toString()

            if (name.isEmpty() || size.isEmpty() || company.isEmpty() || description.isEmpty()) {
                Toast.makeText(context, "Please enter shoe details", Toast.LENGTH_SHORT).show()
            } else {
                saveShoeDetails(name, size, company, description)
            }
        }


        shoesDetailsBinding.cancelButton.setOnClickListener {
            findNavController().navigateUp()

        }

        return shoesDetailsBinding.root
    }

    private fun saveShoeDetails(name: String, size: String, company: String, description: String) {


        shoesViewModel.addShoeDetails(
            "Name: $name",
            "Size: $size",
            "Company: $company",
            "Description: $description"
        )

        findNavController().navigate(ShoesDetailsFragmentDirections.actionShoesDetailsFragmentToShoesFragment())

        Toast.makeText(context, "data saved Successful", Toast.LENGTH_SHORT).show()
    }

}