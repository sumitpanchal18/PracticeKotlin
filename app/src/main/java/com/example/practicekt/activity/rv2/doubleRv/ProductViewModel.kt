package com.example.practicekt.activity.rv2.doubleRv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val repository = ProductRepository()

    private val _products = MutableLiveData<List<ProductDataModelItem>>()
    val products: LiveData<List<ProductDataModelItem>> = _products

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                val productList = repository.getProducts()
                _products.postValue(productList)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}