package com.harunbekcan.samplejetpackcomposeproject.data.response


import com.google.gson.annotations.SerializedName

data class CryptoListResponseItem(
    @SerializedName("id")
    val id: String?,
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("price")
    val price: String?,
)