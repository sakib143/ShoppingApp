package com.example.shopingapp.api

//import com.buyamia.data.model.*
import com.example.shopingapp.data.model.AddOrderModel
import com.example.shopingapp.data.model.MainCategoryModel
import com.example.shopingapp.data.model.ProductDetailsModel
import com.example.shopingapp.data.model.SubCategoryModel
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * REST API access points
 */
interface WebServiceInterface {

    @POST("get_spdata")
    suspend fun callMainCategory(@Body jsonObject: JsonObject): Response<MainCategoryModel>

    @POST("get_spdata")
    suspend fun callSubCategory(@Body jsonObject: JsonObject): Response<SubCategoryModel>

    @POST("get_spdata")
    suspend fun callProductDetails(@Body inpurParam: JsonObject): Response<ProductDetailsModel>

    @POST("get_spdata")
    suspend fun callAddOrder(@Body inpurParam: JsonObject): Response<AddOrderModel>
}