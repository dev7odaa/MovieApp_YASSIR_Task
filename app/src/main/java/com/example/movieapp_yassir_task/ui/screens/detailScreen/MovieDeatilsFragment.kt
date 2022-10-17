package com.example.movieapp_yassir_task.ui.screens.detailScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.movieapp_yassir_task.R
import com.example.movieapp_yassir_task.databinding.FragmentMovieDetailsBinding
import com.example.movieapp_yassir_task.utils.Constants
import okhttp3.HttpUrl

class MovieDeatilsFragment : Fragment() {

    val args: MovieDeatilsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMovieDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_movie_details, container, false)

        binding.imageMovieDetails.load(HttpUrl.get(args.imgMovie))
        binding.tvTitleDetail.text = args.title
        binding.tvYear.text = args.year
        binding.tvDescription.text = args.description

        return binding.root
    }
}