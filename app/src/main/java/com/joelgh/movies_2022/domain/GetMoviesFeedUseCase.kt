package com.joelgh.movies_2022.domain

class GetMoviesFeedUseCase(val repository: MoviesRepository) {

    fun execute(): List<MovieFeed> = repository.getAll().map{
            MovieFeed(it.id, it.title, it.year, it.rating, it.posterUrl)
        }

    data class MovieFeed(val id: String, val title: String, val year: String,
                         val rating: String, val posterUrl: String)
}