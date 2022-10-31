package com.example.shopingapp.data.repository

import com.example.shopingapp.data.db.dao.CartDataDao
import com.example.shopingapp.data.db.table.CartData
import javax.inject.Inject

class AddToCartRepository  @Inject constructor(
    private val cartListDao: CartDataDao,
)   : com.example.shopingapp.api.SafeAPIRequest() {

    suspend fun getAllCartItemData(): ArrayList<CartData> {
        val customArray : ArrayList<CartData> = arrayListOf();
        customArray.addAll(cartListDao.getAllCartItemData())
        return customArray
    }

    suspend fun addToCart(itemId: Int,name:String,brandname:String,minimumQty:String,rate:String,imageUrl:String){
        cartListDao.addToCart(itemId,name,brandname,minimumQty,rate,imageUrl)
    }

    suspend fun removeMominData(id: Int){
        cartListDao.deleteMominData(id)
    }
}