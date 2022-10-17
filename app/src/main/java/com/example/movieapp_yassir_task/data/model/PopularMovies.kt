package com.example.movieapp_yassir_task.data.model


import com.google.gson.annotations.SerializedName

data class PopularMovies(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: List<Result?>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
)