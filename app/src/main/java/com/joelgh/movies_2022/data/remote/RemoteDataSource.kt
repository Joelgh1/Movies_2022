package com.joelgh.movies_2022.data.remote

import com.joelgh.movies_2022.domain.MovieModel

interface RemoteDataSource {

    suspend fun getAll(): List<MovieModel>

    suspend fun findById(movieId: String): MovieModel?
}