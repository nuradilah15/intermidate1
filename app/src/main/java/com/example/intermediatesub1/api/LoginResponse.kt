package com.example.intermediatesub1.api

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @field:SerializedName("loginResult")
    val loginApps: loginResultAkun,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)

data class loginResultAkun(
    @field: SerializedName("name")
    val name: String,

    @field: SerializedName("userId")
    val userid: String,

    @field: SerializedName("token")
    val token: String
)
