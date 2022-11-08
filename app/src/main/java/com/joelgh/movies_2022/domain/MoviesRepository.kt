package com.joelgh.movies_2022.domain

interface MoviesRepository {

    fun getAll(): List<MovieModel>
    fun findById(movieId: String): MovieModel?

}