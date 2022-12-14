package com.joelgh.movies_2022.data.local.xml

import android.content.Context
import com.joelgh.movies_2022.R
import com.joelgh.movies_2022.app.commons.KSerializer
import com.joelgh.movies_2022.data.local.LocalDataSource
import com.joelgh.movies_2022.domain.MovieModel

class XmlLocalDataSource(val context: Context, val serializer: KSerializer) : LocalDataSource{

    val sharedPrefs = context.getSharedPreferences(context.getString(R.string.shared_prefs_name), Context.MODE_PRIVATE)

    override fun getAll(): List<MovieModel> = sharedPrefs.all.map {
            serializer.fromJson(it.value.toString(), MovieModel::class.java)
        }

    override fun findById(movieId: String): MovieModel? = serializer.fromJson(
        sharedPrefs.getString(movieId, null), MovieModel::class.java)

    override fun save(movies: List<MovieModel>) {
        movies.forEach { save(it) }
    }

    private fun save(movie: MovieModel){
        sharedPrefs.edit().apply {
            putString(movie.id, serializer.toJson(movie, MovieModel::class.java))
        }
    }
}