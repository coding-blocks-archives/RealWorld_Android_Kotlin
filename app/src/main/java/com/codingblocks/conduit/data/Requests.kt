package com.codingblocks.conduit.data
import com.google.gson.annotations.SerializedName


data class UserLoginRequest(
    @SerializedName("user")
    val user: User
) {
    data class User(
        @SerializedName("email")
        val email: String,
        @SerializedName("password")
        val password: String
    )
}

data class UserRegisterRequest(
    @SerializedName("user")
    val user: User
) {
    data class User(
        @SerializedName("email")
        val email: String,
        @SerializedName("password")
        val password: String,
        @SerializedName("username")
        val username: String
    )
}

data class UserUpdateRequest(
    @SerializedName("user")
    val user: User
) {
    data class User(
        @SerializedName("bio")
        val bio: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("image")
        val image: String
    )
}