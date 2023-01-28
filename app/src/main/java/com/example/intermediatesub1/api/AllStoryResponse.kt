package com.example.intermediatesub1.api

import com.google.gson.annotations.SerializedName

data class AllStoryResponse(
    @field: SerializedName("listStory")
    val listStory: List<ListAllStoryItem>,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)

data class ListAllStoryItem(
    @field: SerializedName("photoUrl")
    val photoUrl: String,

    @field:SerializedName("createdAt")
    val createdAt: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("id")
    val id: String

)
