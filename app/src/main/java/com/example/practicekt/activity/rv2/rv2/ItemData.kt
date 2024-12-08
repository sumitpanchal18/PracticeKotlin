package com.example.practicekt.activity.rv2.rv2

data class ItemData(
    val name: String,
    val description: String,
    val imageResId: Int,
    val subItems: List<ItemData>? = null
)
