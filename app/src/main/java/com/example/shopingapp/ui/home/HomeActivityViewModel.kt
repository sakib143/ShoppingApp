package com.example.shopingapp.ui.home

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopingapp.MyApplication
import com.example.shopingapp.utils.GlobalMethods
import javax.inject.Inject

class HomeActivityViewModel @Inject constructor(
    private val application: MyApplication,
    private val globalMethods: GlobalMethods
) : AndroidViewModel(application) {

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> get() = _userName

    private val _currentDayName = MutableLiveData<String>()
    val currentDayName: LiveData<String> get() = _currentDayName

    private val _strDate = MutableLiveData<String>()
    val strDate: LiveData<String> get() = _strDate

    fun getUserName() {
        _userName.postValue("Heff Hardy")
        _currentDayName.postValue(globalMethods.getCurrentDayName())
        _strDate.postValue(globalMethods.getDateForSideMenu())
    }


}