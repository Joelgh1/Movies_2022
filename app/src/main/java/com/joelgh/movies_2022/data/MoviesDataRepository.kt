package com.joelgh.movies_2022.data

import com.joelgh.movies_2022.data.local.LocalDataSource
import com.joelgh.movies_2022.domain.MovieModel
import com.joelgh.movies_2022.domain.MoviesRepository

class MoviesDataRepository(val localSource: LocalDataSource) : MoviesRepository{

    override fun getAll(): List<MovieModel> = localSource.getAll()

    override fun findById(movieId: String): MovieModel? = localSource.findById(movieId)
}