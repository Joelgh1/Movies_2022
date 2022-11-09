package com.joelgh.movies_2022.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {
    @Query("SELECT * FROM $TABLE_MOVIE")
    fun getAll(): List<MovieEntity>

    @Query("SELECT * FROM $TABLE_MOVIE WHERE id = :movieID")
    fun findById(movieID: String): MovieEntity?

    @Insert
    fun insertAll(vararg movies: MovieEntity)
}