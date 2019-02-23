package com.codingblocks.conduit.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ConduitApiInterface {
    @GET("articles")
    fun getArticles (@Query("limit") limit: Int = 200): Call<ArticleArrayResponse>
}