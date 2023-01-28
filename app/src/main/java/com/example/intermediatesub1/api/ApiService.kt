package com.example.intermediatesub1.api

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("/v1/register")
    fun signupAccountStory(@Field("name")name: String,
                           @Field("email")email: String,
                           @Field("password")password: String,
                           ): Call<ApiRegisResponse>

    @FormUrlEncoded
    @POST("/v1/login")
    fun loginAccountStory(@Field("email")email: String,
                          @Field("password")password: String,
                          ): Call<LoginResponse>

    @Multipart
    @POST("/v1/stories")
    fun uploadImageApps(@Part file : MultipartBody.Part,
                        @Part("description") description: RequestBody,
                        @Header("Authorization") token: String
                        ): Call<ApiRegisResponse>

    @GET("/v1/stories")
    fun getAllStoryApps(@Header("Authorization")token: String
    ): Call<AllStoryResponse>
}