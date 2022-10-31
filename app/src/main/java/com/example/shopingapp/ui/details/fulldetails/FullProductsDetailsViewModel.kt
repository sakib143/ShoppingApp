package com.example.shopingapp.ui.details.fulldetails

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopingapp.MyApplication
import com.example.shopingapp.data.db.table.CartData
import com.example.shopingapp.data.model.AddOrderModel
import com.example.shopingapp.data.model.ProductDetailsModel
import com.example.shopingapp.data.repository.AddToCartRepository
import com.example.shopingapp.utils.*
import javax.inject.Inject
import kotlin.math.min

class FullProductsDetailsViewModel @Inject constructor(
    private val application: MyApplication,
    private val repository: AddToCartRepository,
    private val prefUtils: PrefUtils,
    private val globalMethods: GlobalMethods
) : AndroidViewModel(application) {

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> get() = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> get() = _onMessageError

    private val _addOrder: MutableLiveData<AddOrderModel> =
        MutableLiveData<AddOrderModel>()
    val addOrder: LiveData<AddOrderModel>
        get() = _addOrder

    val alLeadTime: ArrayList<ProductDetailsModel> = ArrayList()
    private var from : String? = ""
    private var to : String? = ""
    private var price : String? = ""

    var enterQty = MutableLiveData<String>()
    var totalprice = MutableLiveData<String>()

    private val _minimumQty: MutableLiveData<String> =
        MutableLiveData<String>()
    val minimumQty: LiveData<String>
        get() = _minimumQty


    private val _rate: MutableLiveData<String> =
        MutableLiveData<String>()
    val rate: LiveData<String>
        get() = _rate

    private val _itemId: MutableLiveData<Int> =
        MutableLiveData<Int>()
    val itemId: LiveData<Int>
        get() = _itemId

    private val _brandname: MutableLiveData<String> =
        MutableLiveData<String>()
    val brandname: LiveData<String>
        get() = _brandname

    private val _imageUrl: MutableLiveData<String> =
        MutableLiveData<String>()
    val imageUrl: LiveData<String>
        get() = _imageUrl

    private val _name: MutableLiveData<String> =
        MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name


    private val _productDetailsModel: MutableLiveData<ProductDetailsModel.Data> =
        MutableLiveData<ProductDetailsModel.Data>()
    val productDetailsModel: LiveData<ProductDetailsModel.Data>
        get() = _productDetailsModel



    fun setRequiredDetails(
        qty: String,
        rate: String,
        itemid: Int,
        imageUrl: String,
        brandname: String,
        name: String,
    ) {
        _minimumQty.postValue(qty)
        _rate.postValue(rate)
        _brandname.postValue(brandname)
        _itemId.postValue(itemid)
        _imageUrl.postValue(imageUrl)
        _name.postValue(name)
        enterQty.postValue(qty)
    }


    fun addCartData() {
        Coroutines.io {
            if (minimumQty.value!!.isNullOrEmpty()) {
                application.toast("No data")
            } else if (rate.value!!.isNullOrEmpty()) {
                application.toast("No data")
            } else if (brandname.value!!.isNullOrEmpty()) {
                application.toast("No data")
            } else if (itemId.value == null) {
                application.toast("No data")
            } else if (imageUrl.value!!.isNullOrEmpty()) {
                application.toast("No data")
            } else if (name.value!!.isNullOrEmpty()) {
                application.toast("No data")
            } else {
                LogM.e("==>check data is comp: " + itemId.value!! + name.value!! + brandname.value!! + minimumQty.value!! + rate.value!! + imageUrl.value!!)
                repository.addToCart(itemId.value!!,
                    name.value!!,
                    brandname.value!!,
                    enterQty.value!!,
                    rate.value!!,
                    imageUrl.value!!)
            }

        }
    }

    fun minQtyPlus() {
        var entQty = enterQty.value?.toInt()!!
        val moq = minimumQty.value?.toInt()
        if ( entQty >= moq!!) {
            entQty += 1
            enterQty.postValue(entQty.toString())
            //totalprice.postValue(globalMethods.currencyFormat(entQty.toString()))
          /*  for (i in alLeadTime.indices ) {
                when(entQty) {
                    in alLeadTime[i].data[0].defaultRetailRate?.toInt()!!..alLeadTime[i].data[0]?.defaultWholeSaleRate.toInt()!! -> {
                        val rat : Int = alLeadTime[i].data[0].defaultMRP.toInt()
                        entQty*=rat
                        totalprice.postValue(globalMethods.currencyFormat(entQty.toString()))
                    }
                }
            }*/
        }
    }

      fun minQtyMinus() {
          var entQty = enterQty.value?.toInt()!!
          if ( entQty > minimumQty.value?.toInt()!!)
              {
              entQty-=1
              enterQty.postValue(entQty.toString())
                  val rat : Int = rate.value?.toInt()!!
                  entQty*=rat
                  //totalprice.postValue(globalMethods.currencyFormat(entQty.toString()))
          }
      }

}