package com.example.shopingapp.ui.home

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopingapp.MyApplication
import com.example.shopingapp.utils.PrefUtils
import javax.inject.Inject

class HomeActivityViewModel @Inject constructor(
    private val application: MyApplication,
    private val prefUtils: PrefUtils
) : AndroidViewModel(application) {


    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> get() = _onMessageError

    private val _cartCount = MutableLiveData<String>()
    val cartCount: LiveData<String> get() = _cartCount

}