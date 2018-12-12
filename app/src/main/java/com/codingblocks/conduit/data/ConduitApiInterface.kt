package com.codingblocks.conduit.data

import retrofit2.Call
import retrofit2.http.GET

interface ConduitApiInterface {
    @GET("articles")
    fun getArticles (): Call<ArticleArrayResponse>
}