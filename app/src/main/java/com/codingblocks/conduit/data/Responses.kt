package com.codingblocks.conduit.data

import com.codingblocks.conduit.data.models.*
import com.google.gson.annotations.SerializedName


data class ArticleResponse(
    @SerializedName("article")
    var article: Article
)

data class ArticleArrayResponse(
    @SerializedName("articles")
    var articles: ArrayList<Article>,

    @SerializedName("articlesCount")
    var articlesCount: Int

)


data class ProfileResponse(
    @SerializedName("profile")
    var profile: Profile
)


data class UserResponse(
    @SerializedName("user")
    var user: User
)

data class CommentResponse(
    @SerializedName("comment")
    var comment: Comment
)


data class CommentArrayResponse(
    @SerializedName("comments")
    var comments: List<Comment>
)

