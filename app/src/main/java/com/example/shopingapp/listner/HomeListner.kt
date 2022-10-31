package com.example.shopingapp.listner

import com.example.shopingapp.data.model.MainCategoryModel

interface HomeListner {
    fun openSubCategory(model: MainCategoryModel.Data)

}