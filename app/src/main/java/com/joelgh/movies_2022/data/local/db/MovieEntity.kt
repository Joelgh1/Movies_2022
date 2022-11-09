package com.joelgh.movies_2022.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_MOVIE = "movie_entity"

@Entity(tableName = TABLE_MOVIE)
data class MovieEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "plot") val plot: String,
    @ColumnInfo(name = "genre") val genre: String,
    @ColumnInfo(name = "rating") val rating: String,
    @ColumnInfo(name = "year") val year: String,
    @ColumnInfo(name = "posterUrl") val posterUrl: String
)