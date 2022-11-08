package com.joelgh.movies_2022.data.local.mem

import com.joelgh.movies_2022.app.data.mem.MemDataStore
import com.joelgh.movies_2022.data.local.MoviesLocalSource
import com.joelgh.movies_2022.domain.MovieModel

class MoviesMemLocalDataSource(private val memStore: MemDataStore<MovieModel>) : MoviesLocalSource {

    override fun getAll(): List<MovieModel> = memStore.getAll()

    override fun findById(movieId: String): MovieModel? = memStore.get(movieId)

    override fun save(movies: List<MovieModel>) {
        movies.forEach { saveOne(it) }
    }

    private fun saveOne(movie: MovieModel){
        memStore.put(movie.id, movie)
    }
}