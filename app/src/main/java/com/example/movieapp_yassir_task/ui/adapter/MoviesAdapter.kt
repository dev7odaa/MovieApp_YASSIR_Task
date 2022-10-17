package com.example.movieapp_yassir_task.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.movieapp_yassir_task.R
import com.example.movieapp_yassir_task.data.model.Result
import com.example.movieapp_yassir_task.ui.screens.mainScreen.MovieListFragment
import com.example.movieapp_yassir_task.utils.Constants
import okhttp3.HttpUrl

class MoviesAdapter(var movieList: MutableList<Result>):
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_items, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = movieList[position].title.toString()
        holder.year.text = movieList[position].releaseDate.toString()
        holder.img_movie.load(HttpUrl.get(Constants.IMAGE_BASE_URL+movieList[position].image)) {
            size(300, 450)
        }

        holder.itemView.setOnClickListener {
            var title = movieList[position].title.toString()
            var year = movieList[position].releaseDate.toString()
            var description = movieList[position].releaseDate.toString()
            var img_movie = Constants.IMAGE_BASE_URL+movieList[position].image.toString()

            //itemClick.onItemClicked(img_movie, title, year, description)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val title: TextView = itemView.findViewById(R.id.txt_title)
        val year: TextView = itemView.findViewById(R.id.txt_year)
        val img_movie: ImageView = itemView.findViewById(R.id.imageMovie)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(list: MutableList<Result>) {
        movieList.clear()
        movieList.addAll(list)
        notifyDataSetChanged()
    }

    //interface item listener
    interface OnItemClick {
        fun onItemClicked(img_movie: String, title: String, year: String, description: String)
    }
}