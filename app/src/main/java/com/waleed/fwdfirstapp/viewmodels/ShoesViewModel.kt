package com.waleed.fwdfirstapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.waleed.fwdfirstapp.models.Shoe

class ShoesViewModel : ViewModel() {

    private var shoesList = mutableListOf<Shoe>()

    private var _shoes = MutableLiveData<List<Shoe>>()

    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    fun addShoeDetails(name: String, size: String, company: String, description: String) {
        val newItem = Shoe(name, size, company, description)
        newItem.let { item ->
            shoesList.add(item)
            _shoes.value = shoesList
        }
    }
}