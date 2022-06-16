package com.example.shopingapp.data.model


import com.google.gson.annotations.SerializedName

data class MainCategoryModel(
    @SerializedName("data")
    val `data`: List<Data> = listOf(),
    @SerializedName("message")
    val message: String = "",
    @SerializedName("status")
    val status: Boolean = false
) {
    data class Data(
        @SerializedName("banner1")
        val banner1: String = "",
        @SerializedName("banner2")
        val banner2: String = "",
        @SerializedName("imagefile")
        val imagefile: String = "",
        @SerializedName("ItemCategoryCode")
        val itemCategoryCode: String = "",
        @SerializedName("ItemCategoryName")
        val itemCategoryName: String = ""
    )
}