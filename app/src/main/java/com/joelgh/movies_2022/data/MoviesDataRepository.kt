package com.joelgh.movies_2022.data

import com.joelgh.movies_2022.data.local.MoviesLocalSource
import com.joelgh.movies_2022.domain.MovieModel
import com.joelgh.movies_2022.domain.MoviesRepository

class MoviesDataRepository(private val localSource: MoviesLocalSource) : MoviesRepository{

    override fun getAll(): List<MovieModel> = localSource.getAll()

    override fun findById(movieId: String): MovieModel? = localSource.findById(movieId)
}