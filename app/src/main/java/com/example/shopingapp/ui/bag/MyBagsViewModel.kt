package com.example.shopingapp.ui.bag

import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopingapp.MyApplication
import com.example.shopingapp.data.repository.SubCategoryRepository
import com.example.shopingapp.utils.toast
import javax.inject.Inject

class MyBagsViewModel @Inject constructor(
    private val application: MyApplication,
    private val repository: SubCategoryRepository,
) : AndroidViewModel(application) {

    private val _totalItems: MutableLiveData<List<String>> =
        MutableLiveData<List<String>>()
    val totalItems: LiveData<List<String>>
        get() = _totalItems

    init {
        val list = ArrayList<String>()
        list.add("1")
        list.add("2")
        list.add("3")
        _totalItems.postValue(list)
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

    fun addToCart() {
        application.toast("Product added successfully !!! ")
    }
}