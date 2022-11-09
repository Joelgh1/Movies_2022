package com.joelgh.movies_2022.data.local.db

import com.joelgh.movies_2022.domain.MovieModel

fun MovieModel.toEntity() = MovieEntity(this.id, this.title, this.plot,
    this.genre, this.rating, this.year, this.posterUrl)

fun MovieEntity.toDomain() = MovieModel(this.id, this.title, this.plot,
    this.genre, this.rating, this.year, this.posterUrl)