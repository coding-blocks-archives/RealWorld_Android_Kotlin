package com.codingblocks.conduit.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ConduitApiInterface {
    @GET("articles")
    fun getArticles (@Query("limit") limit: Int = 200): Call<ArticleArrayResponse>

    @POST("users/login")
    fun loginUser(@Body userData: UserLoginRequest): Call<UserResponse>

    @POST("users")
    fun registerUser(@Body userData: UserRegisterRequest): Call<UserResponse>

    @GET("user")
    fun getCurrentUser(): Call<UserResponse>
}