package com.joelgh.movies_2022.data.local.db

import com.joelgh.movies_2022.app.data.db.Database
import com.joelgh.movies_2022.data.local.LocalDataSource
import com.joelgh.movies_2022.domain.MovieModel

class MoviesDbLocalDataSource(private val db: Database) : LocalDataSource {

    override fun getAll(): List<MovieModel> = db.movieDao().getAll().map {
        it.toDomain()
    }

    override fun findById(movieId: String): MovieModel? = db.movieDao().findById(movieId)?.toDomain()

    override fun save(movies: List<MovieModel>) {
        movies.forEach {
            db.movieDao().insert(it.toEntity())
        }
    }
}