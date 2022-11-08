package com.joelgh.movies_2022.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "title") val title: String
)