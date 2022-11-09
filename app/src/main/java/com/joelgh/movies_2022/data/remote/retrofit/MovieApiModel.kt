package com.joelgh.movies_2022.data.remote.retrofit

data class MovieApiModel(val id: String, val title: String, val plot: String, val genre: String,
                      val rating: String, val year: String,  val posterUrl: String)