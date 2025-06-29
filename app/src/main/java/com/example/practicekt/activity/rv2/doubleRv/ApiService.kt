package com.example.practicekt.activity.rv2.doubleRv

import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts(): List<ProductDataModelItem>

}