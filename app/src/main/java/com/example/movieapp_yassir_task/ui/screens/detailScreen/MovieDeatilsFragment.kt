package com.example.movieapp_yassir_task.ui.screens.detailScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.movieapp_yassir_task.R
import com.example.movieapp_yassir_task.databinding.FragmentMovieDeatilsBinding

class MovieDeatilsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMovieDeatilsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_movie_deatils, container, false)

        return binding.root
    }
}