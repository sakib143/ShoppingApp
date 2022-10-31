package com.example.shopingapp.data.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ProductDetailsModel(
    @SerializedName("data") val `data`: List<Data> = listOf(),
    @SerializedName("message") val message: String = "",
    @SerializedName("status") val status: Boolean = false
) {
    @Keep
    data class Data(
        @SerializedName("BrandName") var brandName: String = "",
        @SerializedName("brandcode") val brandcode: Int = 0,
        @SerializedName("DefaultMRP") val defaultMRP: Int = 0,
        @SerializedName("DefaultRetailRate") val defaultRetailRate: Int = 0,
        @SerializedName("DefaultWholeSaleRate") val defaultWholeSaleRate: Int = 0,
        @SerializedName("ImageName") val imageName: String = "",
        @SerializedName("ItemCategoryCode") val itemCategoryCode: Int = 0,
        @SerializedName("itemid") val itemid: Int = 0,
        @SerializedName("MinSellQuantity") val minSellQuantity: String = "",
        @SerializedName("name") val name: String = "",
        @SerializedName("PatternCode") val patternCode: Int = 0,
        @SerializedName("PrintName") val printName: String = "",
        @SerializedName("StyleCode") val styleCode: Int = 0
    )
}