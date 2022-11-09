package com.joelgh.movies_2022.data.remote.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoints {
    @GET("movies")
    fun getAll(): Call<List<MovieApiModel>>
    @GET("movies/{movieId}")
    fun findById(@Path("movieId") movieId: String): Call<MovieApiModel>
}