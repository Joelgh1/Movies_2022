package com.joelgh.movies_2022.domain

data class MovieModel(val id: String, val title: String, val plot: String, val genre: String,
                      val rating: String, val year: String,  val posterUrl: String)