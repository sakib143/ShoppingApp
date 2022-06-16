package com.example.shopingapp.data.repository

import com.example.shopingapp.api.SafeAPIRequest
import com.example.shopingapp.api.WebServiceInterface
import com.example.shopingapp.data.model.MainCategoryModel
import com.google.gson.JsonObject
import javax.inject.Inject

class HomeRepository@Inject constructor(
    private val webServiceInterface: WebServiceInterface
) : SafeAPIRequest() {

    suspend fun callMainCategory(objectLogin: JsonObject): MainCategoryModel {
        return apiRequest {
            webServiceInterface.callMainCategory(objectLogin)
        }
    }
}