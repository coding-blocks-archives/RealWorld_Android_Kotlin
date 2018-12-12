package com.codingblocks.conduit.data.models

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("bio")
    var bio: String,
    @SerializedName("following")
    var following: Boolean,
    @SerializedName("image")
    var image: String,
    @SerializedName("username")
    var username: String
)