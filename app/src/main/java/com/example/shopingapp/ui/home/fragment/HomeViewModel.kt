package com.example.shopingapp.ui.home.fragment

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopingapp.MyApplication
import com.example.shopingapp.api.ApiExceptions
import com.example.shopingapp.api.NoInternetException
import com.example.shopingapp.data.model.MainCategoryModel
import com.example.shopingapp.data.repository.HomeRepository
import com.example.shopingapp.utils.Constant
import com.example.shopingapp.utils.Coroutines
import com.example.shopingapp.utils.PrefUtils
import com.google.gson.JsonObject
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val application: MyApplication,
    private val repository: HomeRepository,
    private val prefUtils: PrefUtils
) : AndroidViewModel(application) {

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> get() = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> get() = _onMessageError

    private val _mainCategory: MutableLiveData<List<MainCategoryModel.Data>> =
        MutableLiveData<List<MainCategoryModel.Data>>()
    val mainCategory: LiveData<List<MainCategoryModel.Data>>
        get() = _mainCategory

    init {
        callMainCategory()
    }

    fun callMainCategory() {
        Coroutines.main {
            try {
                val inputParam = JsonObject()
                inputParam.addProperty(Constant.REQUEST_MODE, Constant.REQUEST_MAIN_CATEGORY)
                inputParam.addProperty(Constant.REQUEST_USERID, "68")
                _isViewLoading.postValue(true)
                val apiResponse = repository.callMainCategory(inputParam)
                if( ! apiResponse.status) {
                    _onMessageError.postValue(apiResponse.message)
                }
                _isViewLoading.postValue(false)
                _mainCategory.postValue(apiResponse.data)
            } catch (e: ApiExceptions) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(e.message)
            } catch (e: NoInternetException) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(e.message)
            }
        }
    }
}
