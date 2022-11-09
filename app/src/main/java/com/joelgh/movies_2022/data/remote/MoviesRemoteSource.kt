package com.joelgh.movies_2022.data.remote

import com.joelgh.movies_2022.domain.MovieModel

interface MoviesRemoteSource {

    fun getAll(): List<MovieModel>

    fun findById(movieId: String): MovieModel?
}