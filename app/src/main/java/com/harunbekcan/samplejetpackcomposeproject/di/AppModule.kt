package com.harunbekcan.samplejetpackcomposeproject.di

import com.harunbekcan.samplejetpackcomposeproject.data.ServiceInterface
import com.harunbekcan.samplejetpackcomposeproject.utils.Constants.BASE_URL
import com.harunbekcan.samplejetpackcomposeproject.utils.CustomHttpLogger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCryptoApi(httpClient: OkHttpClient): ServiceInterface {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(httpClient)
            .build()
            .create(ServiceInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val logging = HttpLoggingInterceptor(CustomHttpLogger())
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

}