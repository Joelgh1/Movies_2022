package com.joelgh.movies_2022.data.local.xml

import android.content.Context
import com.joelgh.movies_2022.data.local.MoviesLocalSource
import com.joelgh.movies_2022.domain.MovieModel

class MoviesXmlLocalDataSource(val context: Context) : MoviesLocalSource{

    val sharedPrefs = context.getSharedPreferences("Movies", Context.MODE_PRIVATE)

    override fun getAll(): List<MovieModel> {
        TODO("Not yet implemented")
    }

    override fun findById(movieId: String): MovieModel? {
        TODO("Not yet implemented")
    }

    override fun save(movies: List<MovieModel>) {
        TODO("Not yet implemented")
    }
}