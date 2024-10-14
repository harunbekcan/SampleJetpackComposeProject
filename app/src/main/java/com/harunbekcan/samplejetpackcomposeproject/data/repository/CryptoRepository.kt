package com.harunbekcan.samplejetpackcomposeproject.data.repository

import com.harunbekcan.samplejetpackcomposeproject.data.response.CryptoListResponse
import com.harunbekcan.samplejetpackcomposeproject.data.response.CryptoListResponseItem
import com.harunbekcan.samplejetpackcomposeproject.data.service.ServiceInterface
import com.harunbekcan.samplejetpackcomposeproject.utils.Constants
import com.harunbekcan.samplejetpackcomposeproject.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CryptoRepository @Inject constructor (private val serviceInterface: ServiceInterface) {

    suspend fun getCryptoList(): Resource<CryptoListResponse> {
        // Servis bağlantısı artık çalışmıyor o yüzden dummyList oluşturuldu !
        val dummyList = arrayListOf(
            CryptoListResponseItem(id = "1", currency = "Bitcoin", price = "45000.00"),
            CryptoListResponseItem(id = "2", currency = "Ethereum", price = "3000.00"),
            CryptoListResponseItem(id = "3", currency = "Ripple", price = "0.50"),
            CryptoListResponseItem(id = "4", currency = "Litecoin", price = "150.00")
        )

        val response = CryptoListResponse().apply { addAll(dummyList) }

        return try {
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error("Error !")
        }
    }


}