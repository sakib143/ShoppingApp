package com.example.shopingapp.ui.cart

import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopingapp.MyApplication
import com.example.shopingapp.data.db.table.CartData
import com.example.shopingapp.data.repository.AddToCartRepository
import com.example.shopingapp.utils.Coroutines
import com.example.shopingapp.utils.LogM
import com.example.shopingapp.utils.toast
import javax.inject.Inject

class CartViewModel @Inject constructor(
    private val application: MyApplication,
    private val repository: AddToCartRepository,
) : AndroidViewModel(application) {

    private val _isNoDataFound: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>()
    val isNoDataFound: LiveData<Boolean>
        get() = _isNoDataFound

    fun setNoDataFound(isDataLoad: Boolean) {
        _isNoDataFound.postValue(isDataLoad)
    }

    private val _cartList: MutableLiveData<ArrayList<CartData>> =
        MutableLiveData<ArrayList<CartData>>()
    val cartList: LiveData<ArrayList<CartData>>
        get() = _cartList

    init {
        Coroutines.io {
            _cartList.postValue(repository.getAllCartItemData())
        }
    }

    fun callDeleteCart(model: Int) {
        Coroutines.io {
            repository.removeMominData(model)
            _cartList.postValue(repository.getAllCartItemData())
        }
    }

    fun onTotalItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
//        varientTwoSelection = _varientTwoList.value?.get(pos).toString()
//        LogM.e("==> onVarientOneseSelection " + varientTwoSelection)

        //pos                                 get selected item position
        //view.getText()                      get lable of selected item
        //parent.getAdapter().getItem(pos)    get item by pos
        //parent.getAdapter().getCount()      get item count
        //parent.getCount()                   get item count
        //parent.getSelectedItem()            get selected item
        //and other...
    }
}