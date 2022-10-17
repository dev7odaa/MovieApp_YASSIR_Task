package com.example.movieapp_yassir_task.ui.screens.mainScreen

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp_yassir_task.R
import com.example.movieapp_yassir_task.data.model.PopularMovies
import com.example.movieapp_yassir_task.data.model.Result
import com.example.movieapp_yassir_task.databinding.FragmentMovieListBinding
import com.example.movieapp_yassir_task.ui.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.movie_items.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListFragment: Fragment(), MoviesAdapter.OnItemClick{

    lateinit var _viewModel: MovieListFragmentViewModel

    private lateinit var resultMovies: MutableList<Result>

    private lateinit var recyclerview: RecyclerView
    private lateinit var moviesAdapter: MoviesAdapter

//DetailMovieFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMovieListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_movie_list, container, false)

        recyclerview = binding.movieList
        resultMovies = ArrayList()

        initList()
        initViewModel()

        return binding.root
    }

    private fun initList() {
        moviesAdapter = MoviesAdapter(mutableListOf(), this)
        recyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = moviesAdapter
        }
    }

    private fun initViewModel() {
        _viewModel = ViewModelProvider(this)[MovieListFragmentViewModel::class.java]
        _viewModel.initViewModel(requireContext())

        GlobalScope.launch {
            _viewModel.getPopularMoviesUI().collect {
                resultMovies.clear()
                resultMovies.addAll(it)
                withContext(Dispatchers.Main) {
                    moviesAdapter.refreshData(resultMovies)
                }
            }
        }
    }

    override fun onItemClicked(
        img_movie: String,
        title: String,
        year: String,
        description: String
    ) {

        val action = MovieListFragmentDirections.actionMovieListToMovieDeatilsFragment(img_movie , title, year, description)
        Navigation.findNavController(requireView()).navigate(action)

    }
}