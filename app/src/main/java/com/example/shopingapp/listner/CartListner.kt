package com.example.shopingapp.listner

import com.example.shopingapp.data.db.table.CartData

interface CartListner {
    fun deletfromcart(model : CartData)
}