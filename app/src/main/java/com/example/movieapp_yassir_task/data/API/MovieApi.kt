package com.example.movieapp_yassir_task.data.API

import com.example.movieapp_yassir_task.data.model.PopularMovies
import com.example.movieapp_yassir_task.data.model.Result
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET("/3/movie/popular?api_key=c9856d0cb57c3f14bf75bdc6c063b8f3")
    suspend fun getPopularMovies(): PopularMovies

}
