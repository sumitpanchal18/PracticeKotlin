package com.example.practicekt.activity.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataBViewModel : ViewModel() {
    private val _welcomeMessage = MutableLiveData("Welcome to Data Binding with ViewModel!")

    val welcomeMessage: LiveData<String>
        get() = _welcomeMessage

}
