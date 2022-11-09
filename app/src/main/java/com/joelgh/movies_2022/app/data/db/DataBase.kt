package com.joelgh.movies_2022.app.data.db

import androidx.room.RoomDatabase
import androidx.room.Database
import com.joelgh.movies_2022.data.local.db.MovieDao
import com.joelgh.movies_2022.data.local.db.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}