package com.harunbekcan.samplejetpackcomposeproject.data.repository

import com.harunbekcan.samplejetpackcomposeproject.data.response.CryptoListResponse
import com.harunbekcan.samplejetpackcomposeproject.data.service.ServiceInterface
import com.harunbekcan.samplejetpackcomposeproject.utils.Constants
import com.harunbekcan.samplejetpackcomposeproject.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CryptoRepository @Inject constructor (private val serviceInterface: ServiceInterface) {

    suspend fun getCryptoList(): Resource<CryptoListResponse> {
        val response = try {
            serviceInterface.getCurrencies(Constants.API_KEY)
        } catch (e: Exception) {
            return Resource.Error("Error !")
        }
        return Resource.Success(response)
    }
}