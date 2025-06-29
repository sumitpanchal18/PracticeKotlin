package com.example.practicekt.activity.rv2.doubleRv

class ProductRepository {
    suspend fun getProducts(): List<ProductDataModelItem> {
        return RetrofitInstance.api.getProducts()
    }
}