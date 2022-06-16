package com.example.shopingapp.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class SubCategoryModel(
    @SerializedName("data")
    val `data`: List<Data> = listOf(),
    @SerializedName("message")
    val message: String = "",
    @SerializedName("status")
    val status: Boolean = false
) {
    @Keep
    data class Data(
        @SerializedName("imagefile")
        val imagefile: String = "",
        @SerializedName("ItemCategoryCode")
        val itemCategoryCode: Int = 0,
        @SerializedName("ItemCategoryName")
        val itemCategoryName: String = "",
        @SerializedName("itemcnt")
        val itemcnt: Int = 0
    )
}