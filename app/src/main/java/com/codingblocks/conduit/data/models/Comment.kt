package com.codingblocks.conduit.data.models

import com.google.gson.annotations.SerializedName

data class Comment(
    @SerializedName("author")
    var author: Author,
    @SerializedName("body")
    var body: String,
    @SerializedName("createdAt")
    var createdAt: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("updatedAt")
    var updatedAt: String
)