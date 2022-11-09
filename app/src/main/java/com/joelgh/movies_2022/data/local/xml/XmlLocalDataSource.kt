package com.joelgh.movies_2022.data.local.xml

import android.content.Context
import com.joelgh.movies_2022.app.commons.KSerializer
import com.joelgh.movies_2022.data.local.LocalDataSource
import com.joelgh.movies_2022.domain.MovieModel

class XmlLocalDataSource(val context: Context, val serializer: KSerializer) : LocalDataSource{

    val sharedPrefs = context.getSharedPreferences("Movies", Context.MODE_PRIVATE)

    override fun getAll(): List<MovieModel> = sharedPrefs.all.map {
            serializer.fromJson(it.value.toString(), MovieModel::class.java)
        }

    override fun findById(movieId: String): MovieModel? = serializer.fromJson(
        sharedPrefs.getString(movieId, null), MovieModel::class.java)

    override fun save(movies: List<MovieModel>) {
        movies.forEach { saveOne(it) }
    }

    private fun saveOne(movie: MovieModel){
        sharedPrefs.edit().apply {
            putString(movie.id, serializer.toJson(movie, MovieModel::class.java))
        }
    }
}