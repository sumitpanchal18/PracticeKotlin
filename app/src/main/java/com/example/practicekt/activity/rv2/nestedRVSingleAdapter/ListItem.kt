package com.example.practicekt.activity.rv2.nestedRVSingleAdapter

sealed class ListItem {
    data class TypeOne(val title: String) : ListItem()
    data class TypeTwo(val imageResId: Int) : ListItem()
}