package com.example.shopingapp.data.repository

import com.example.shopingapp.api.SafeAPIRequest
import com.example.shopingapp.api.WebServiceInterface
import com.example.shopingapp.data.model.ProductDetailsModel
import com.google.gson.JsonObject

import javax.inject.Inject

class ProductDetailsRepository @Inject constructor(
    private val webServiceInterface: WebServiceInterface
) : SafeAPIRequest() {

    suspend fun callProductDetails(objectLogin: JsonObject): ProductDetailsModel {
        return apiRequest {
            webServiceInterface.callProductDetails(objectLogin)
        }
    }

}