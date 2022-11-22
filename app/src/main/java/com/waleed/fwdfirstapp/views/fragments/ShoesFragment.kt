package com.waleed.fwdfirstapp.views.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.findNavController
import com.waleed.fwdfirstapp.models.Shoe
import com.waleed.fwdfirstapp.R
import com.waleed.fwdfirstapp.databinding.FragmentShoesBinding
import com.waleed.fwdfirstapp.databinding.ShoeListItemBinding
import com.waleed.fwdfirstapp.viewmodels.ShoesViewModel


@Suppress("DEPRECATION")
class ShoesFragment : Fragment() {

    private lateinit var shoesBinding: FragmentShoesBinding

    private lateinit var shoesViewModel: ShoesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        shoesBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoes, container, false
        )
        setHasOptionsMenu(true)

        shoesViewModel = ViewModelProvider(requireActivity())[ShoesViewModel::class.java]

        shoesViewModel.shoes.observe(viewLifecycleOwner) { item: List<Shoe> ->

            addShoesListItem(item)
        }
        shoesBinding.lifecycleOwner = viewLifecycleOwner

        shoesBinding.addShoeFloatingButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(ShoesFragmentDirections.actionShoesFragmentToShoesDetailsFragment())
        }


        addShoesFirstTime()

        return shoesBinding.root
    }


    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logoutMenuItem -> {

                findNavController().navigate(ShoesFragmentDirections.actionShoesFragmentToLoginFragment())

                true
            }
            else -> false

        }

    }


    private fun addShoesListItem(item: List<Shoe>) {


        item.forEach {

            val bindingView = ShoeListItemBinding.inflate(
                LayoutInflater.from(requireContext()),
                shoesBinding.shoeLinearLayout,
                false
            )

            with(bindingView) {
                shoeNameTextView.text = it.name
                shoeSizeTextView.text = it.size
                shoeCompanyTextView.text = it.company
                shoeDescriptionTextView.text = it.description

                shoesBinding.shoeLinearLayout.addView(root)
            }
        }

    }


    private fun addShoesFirstTime() {
        val shoes1 = Shoe(
            "Name: shoe 1", "Size: 16", "Company: adidas",
            "Description: running shoes"
        )

        val bindingView = ShoeListItemBinding.inflate(
            LayoutInflater.from(requireContext()), shoesBinding.shoeLinearLayout, false
        )


        with(bindingView) {
            shoeNameTextView.text = shoes1.name
            shoeSizeTextView.text = shoes1.size
            shoeCompanyTextView.text = shoes1.company
            shoeDescriptionTextView.text = shoes1.description

            shoesBinding.shoeLinearLayout.addView(root)

        }


    }

}

