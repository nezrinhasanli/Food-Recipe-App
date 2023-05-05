package com.nezrin.foodrecipeapp.retrofitclient

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance {
    companion object{
        val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
        private var retrofit: Retrofit? = null
        val retrofitInstance: Retrofit?
            get() {
                if (retrofit == null) {
                    val interceptor = HttpLoggingInterceptor().also {
                        it.level = HttpLoggingInterceptor.Level.BODY
                    }
                    val client = OkHttpClient.Builder().addInterceptor(interceptor)
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(client.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retrofit
            }
    }
}