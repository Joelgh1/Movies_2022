package com.joelgh.movies_2022.data.remote.retrofit

import com.joelgh.movies_2022.domain.MovieModel

fun MovieApiModel.toDomain() = MovieModel(this.id, this.title, this.plot, this.genre,
    this.rating, this.year, this.posterUrl)