package com.example.shopingapp.ui.details

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopingapp.MyApplication
import com.example.shopingapp.api.ApiExceptions
import com.example.shopingapp.api.NoInternetException
import com.example.shopingapp.data.model.ProductDetailsModel
import com.example.shopingapp.data.repository.ProductDetailsRepository
import com.example.shopingapp.utils.Constant
import com.example.shopingapp.utils.Coroutines
import com.example.shopingapp.utils.PrefUtils
import com.example.shopingapp.utils.toast
import com.google.gson.JsonObject

import javax.inject.Inject

class ProductDetailsViewModel @Inject constructor(
    private val application: MyApplication,
    private val repository: ProductDetailsRepository,
    private val prefUtils: PrefUtils
) : AndroidViewModel(application) {

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> get() = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> get() = _onMessageError

    private val _productDetails: MutableLiveData<ProductDetailsModel> =
        MutableLiveData<ProductDetailsModel>()
    val productDetails: LiveData<ProductDetailsModel>
        get() = _productDetails

    private val _isNoDataFound: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val isNoDataFound: LiveData<Boolean>
        get() = _isNoDataFound


    init {
        _isNoDataFound.postValue(true)
    }

    fun setNoDataFound(isDataLoad: Boolean) {
        _isNoDataFound.postValue(isDataLoad)
    }

    fun executeProductList(strItemCatgoryCode: String): LiveData<ProductDetailsModel> {
        Coroutines.main {
            try {
                val inputParam = JsonObject()
                inputParam.addProperty(Constant.REQUEST_USERID, 1)
                inputParam.addProperty(Constant.REQUEST_MODE, Constant.REQUEST_GET_ITEM_LIST_BY_CATEGORY)
                inputParam.addProperty(Constant.REQUEST_ITEM_CATEGORY_CODE, strItemCatgoryCode)
                _isViewLoading.postValue(true)
                val apiResponse = repository.callProductDetails(inputParam)
                _isViewLoading.postValue(false)
                _productDetails.postValue(apiResponse)
            } catch (e: ApiExceptions) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(e.message)
            } catch (e: NoInternetException) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(e.message)
            }
        }
        return _productDetails
    }

}