package com.codingblocks.conduit.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ConduitClient {

    val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(2, TimeUnit.SECONDS)
        .build()

    val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://conduit.productionready.io/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val conduitApi = retrofit.create(ConduitApiInterface::class.java)
}