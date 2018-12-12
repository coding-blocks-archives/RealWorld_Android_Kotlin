package com.codingblocks.conduit.data.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("bio")
    var bio: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("image")
    var image: Any?,
    @SerializedName("token")
    var token: String,
    @SerializedName("username")
    var username: String
)