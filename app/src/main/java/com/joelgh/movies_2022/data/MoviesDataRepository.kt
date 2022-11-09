package com.joelgh.movies_2022.data

import com.joelgh.movies_2022.data.local.LocalDataSource
import com.joelgh.movies_2022.data.remote.RemoteDataSource
import com.joelgh.movies_2022.domain.MovieModel
import com.joelgh.movies_2022.domain.MoviesRepository

class MoviesDataRepository(private val localSource: LocalDataSource,
                           private val remoteSource: RemoteDataSource) : MoviesRepository{

    override fun getAll(): List<MovieModel> {
        var movies = localSource.getAll()

        return movies.ifEmpty {
            movies = remoteSource.getAll()
            localSource.save(movies)
            movies
        }
    }

    override fun findById(movieId: String): MovieModel? {

        return (localSource.findById(movieId) ?: remoteSource.findById(movieId))
    }
}