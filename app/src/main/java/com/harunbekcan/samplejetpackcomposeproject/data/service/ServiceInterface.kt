package com.harunbekcan.samplejetpackcomposeproject.data.service

import com.harunbekcan.samplejetpackcomposeproject.data.response.CryptoListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceInterface {

    //Example_Request = https://api.nomics.com/v1/currencies/ticker?key=af878d71727f90ea12398c681941624b6aeacba0

    /*@GET("currencies/ticker")
    suspend fun getCurrencies(
        @Query("key") key: String
    ): CryptoListResponse*/

}