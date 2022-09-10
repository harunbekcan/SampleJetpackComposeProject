package com.harunbekcan.samplejetpackcomposeproject.data

import retrofit2.http.GET

interface ServiceInterface {

    @GET("currencies/ticker")
    suspend fun getCurrencies()

}