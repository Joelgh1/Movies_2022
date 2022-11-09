package com.joelgh.movies_2022.data.local.db



import android.content.Context
import com.joelgh.movies_2022.app.data.db.Database
import androidx.room.Room
import com.joelgh.movies_2022.data.local.MoviesLocalSource
import com.joelgh.movies_2022.domain.MovieModel

class MoviesDbLocalDataSource(private val applicationContext: Context) : MoviesLocalSource {

    private val db = Room.databaseBuilder(
        applicationContext,
        Database::class.java, "database-name"
    ).build()

    override fun getAll(): List<MovieModel> = db.movieDao().getAll().map {
        it.toDomain()
    }

    override fun findById(movieId: String): MovieModel? = db.movieDao().findById(movieId)?.toDomain()

    override fun save(movies: List<MovieModel>) {
        movies.forEach {
            db.movieDao().insertAll(it.toEntity())
        }
    }
}