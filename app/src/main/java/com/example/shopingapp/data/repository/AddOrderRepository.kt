package com.example.shopingapp.data.repository

import com.example.shopingapp.api.SafeAPIRequest
import com.example.shopingapp.api.WebServiceInterface
import com.example.shopingapp.data.model.AddOrderModel
import com.google.gson.JsonObject

import javax.inject.Inject

class AddOrderRepository @Inject constructor(
    private val webServiceInterface: WebServiceInterface
) : SafeAPIRequest() {

    suspend fun callAddOrder(objectLogin: JsonObject): AddOrderModel {
        return apiRequest {
            webServiceInterface.callAddOrder(objectLogin)
        }
    }

}