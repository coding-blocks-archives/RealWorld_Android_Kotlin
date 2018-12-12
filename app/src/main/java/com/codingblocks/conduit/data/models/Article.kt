package com.codingblocks.conduit.data.models

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("author")
    var author: Author,
    @SerializedName("body")
    var body: String,
    @SerializedName("createdAt")
    var createdAt: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("favorited")
    var favorited: Boolean,
    @SerializedName("favoritesCount")
    var favoritesCount: Int,
    @SerializedName("slug")
    var slug: String,
    @SerializedName("tagList")
    var tagList: List<String>,
    @SerializedName("title")
    var title: String,
    @SerializedName("updatedAt")
    var updatedAt: String
)