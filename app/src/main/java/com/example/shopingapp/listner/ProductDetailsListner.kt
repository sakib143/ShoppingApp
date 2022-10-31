package com.example.shopingapp.listner

import com.example.shopingapp.data.model.ProductDetailsModel

interface ProductDetailsListner {
    fun openProductDetails(model : ProductDetailsModel.Data)
}