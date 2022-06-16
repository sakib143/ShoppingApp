package com.example.shopingapp.data.repository

import com.example.shopingapp.api.SafeAPIRequest
import com.example.shopingapp.api.WebServiceInterface
import com.example.shopingapp.data.model.SubCategoryModel
import com.google.gson.JsonObject
import javax.inject.Inject

class SubCategoryRepository@Inject constructor(
    private val webServiceInterface: WebServiceInterface
) : SafeAPIRequest() {

    suspend fun callSubCategory(objectLogin: JsonObject): SubCategoryModel {
        return apiRequest {
            webServiceInterface.callSubCategory(objectLogin)
        }
    }
}