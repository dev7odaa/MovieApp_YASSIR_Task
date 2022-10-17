package com.example.movieapp_yassir_task.data.API

import com.example.movieapp_yassir_task.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object{
        fun getRetrofitBuilder(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val apiMovie = getRetrofitBuilder().create(MovieApi::class.java)
    }
}