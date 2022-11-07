package com.joelgh.movies_2022.data.local

import com.joelgh.movies_2022.domain.MovieModel

interface MoviesLocalSource {

    fun getAll(): List<MovieModel>
    fun findById(movieId: String): MovieModel?
    fun save(movies: List<MovieModel>)
}