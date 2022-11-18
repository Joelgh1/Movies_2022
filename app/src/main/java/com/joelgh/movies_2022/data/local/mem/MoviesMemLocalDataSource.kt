package com.joelgh.movies_2022.data.local.mem

import com.joelgh.movies_2022.app.data.mem.MemDataStore
import com.joelgh.movies_2022.data.local.LocalDataSource
import com.joelgh.movies_2022.domain.MovieModel

class MoviesMemLocalDataSource(private val memStore: MemDataStore<MovieModel>) : LocalDataSource {

    override fun getAll(): List<MovieModel> = memStore.getAll()

    override fun findById(movieId: String): MovieModel? = memStore.get(movieId)

    override fun save(movies: List<MovieModel>) {
        movies.forEach { save(it) }
    }

    private fun save(movie: MovieModel){
        memStore.put(movie.id, movie)
    }
}