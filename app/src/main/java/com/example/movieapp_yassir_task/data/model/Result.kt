package com.example.movieapp_yassir_task.data.model

import com.google.gson.annotations.SerializedName


data class Result(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("overview")
    val description: String? = null,
    @SerializedName("poster_path")
    val image: String? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    @SerializedName("title")
    val title: String? = null,
)