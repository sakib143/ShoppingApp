package com.example.shopingapp.listner

import com.example.shopingapp.data.model.SubCategoryModel

interface SubCategoryListner {
    fun openSubCategory(model: SubCategoryModel.Data)
}