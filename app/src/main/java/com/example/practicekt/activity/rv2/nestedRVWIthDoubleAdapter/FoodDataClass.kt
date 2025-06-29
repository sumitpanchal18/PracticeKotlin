package com.example.practicekt.activity.rv2.nestedRVWIthDoubleAdapter

data class FoodDataClass(
    val name: String,
    val imageResId: Int,
    val description: String,
    val subItems: List<FoodSubItem>
)

data class FoodSubItem(
    val subName: String,
    val subImageResId: Int,
    val subDescription: String
)
