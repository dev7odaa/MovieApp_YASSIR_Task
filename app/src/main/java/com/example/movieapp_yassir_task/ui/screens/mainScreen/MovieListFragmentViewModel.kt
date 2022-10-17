package com.example.movieapp_yassir_task.ui.screens.mainScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp_yassir_task.data.API.MovieApi
import com.example.movieapp_yassir_task.data.API.RetrofitBuilder
import com.example.movieapp_yassir_task.data.model.PopularMovies
import com.example.movieapp_yassir_task.data.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MovieListFragmentViewModel() : ViewModel() {

    private lateinit var context: Context
    private lateinit var apiMovie: MovieApi

    private lateinit var resultMovieList: MutableStateFlow<MutableList<Result>>

    fun initViewModel(context: Context) {
        this.context = context
        apiMovie = RetrofitBuilder.apiMovie
        resultMovieList = MutableStateFlow(ArrayList())
    }

    fun getPopularMoviesUI(): MutableStateFlow<MutableList<Result>> {
        viewModelScope.launch(Dispatchers.Main) {
            resultMovieList.emit(ArrayList())
            resultMovieList.emit(apiMovie.getPopularMovies().results as MutableList<Result>)
        }
        return resultMovieList
    }
}