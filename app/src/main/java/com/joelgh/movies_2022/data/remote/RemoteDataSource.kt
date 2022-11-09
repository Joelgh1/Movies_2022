package com.joelgh.movies_2022.data.remote

import com.joelgh.movies_2022.domain.MovieModel

interface RemoteDataSource {

    fun getAll(): List<MovieModel>

    fun findById(movieId: String): MovieModel?
}