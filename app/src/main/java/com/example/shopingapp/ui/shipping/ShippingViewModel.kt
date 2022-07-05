package com.example.shopingapp.ui.shipping

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopingapp.MyApplication
import com.example.shopingapp.api.ApiExceptions
import com.example.shopingapp.api.NoInternetException
import com.example.shopingapp.data.model.SubCategoryModel
import com.example.shopingapp.data.repository.SubCategoryRepository
import com.example.shopingapp.utils.Constant
import com.example.shopingapp.utils.Coroutines
import com.example.shopingapp.utils.PrefUtils
import com.google.gson.JsonObject
import javax.inject.Inject

class ShippingViewModel @Inject constructor(
    private val application: MyApplication,
    private val repository: SubCategoryRepository,
    private val prefUtils: PrefUtils
) : AndroidViewModel(application) {

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> get() = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> get() = _onMessageError

    private val _subcategories: MutableLiveData<List<SubCategoryModel.Data>> =
        MutableLiveData<List<SubCategoryModel.Data>>()
    val subcategories: LiveData<List<SubCategoryModel.Data>>
        get() = _subcategories

    fun callSubCategory(categoryId: String) {
        Coroutines.main {
            try {
                val inputParam = JsonObject()
                inputParam.addProperty(Constant.REQUEST_USERID, "68")
                inputParam.addProperty(Constant.REQUEST_MODE, Constant.REQUEST_GETSUBCATEGORYLIST)
                inputParam.addProperty(Constant.REQUEST_ITEMCATEGORYCODE, categoryId)
                _isViewLoading.postValue(true)
                val apiResponse = repository.callSubCategory(inputParam)
                if( ! apiResponse.status) {
                    _onMessageError.postValue(apiResponse.message)
                }
                _isViewLoading.postValue(false)
                _subcategories.postValue(apiResponse.data)
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
