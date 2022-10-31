package com.example.shopingapp.data.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class AddOrderModel(
    @SerializedName("data") val `data`: List<Data> = listOf(),
    @SerializedName("message") val message: String = "",
    @SerializedName("status") val status: Boolean = false
) {
    @Keep
    data class Data(
        @SerializedName("message") val message: String = "",
        @SerializedName("status") val status: String = ""
    )
}