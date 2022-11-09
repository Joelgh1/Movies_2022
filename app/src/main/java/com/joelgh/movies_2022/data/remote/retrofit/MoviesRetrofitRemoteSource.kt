package com.joelgh.movies_2022.data.remote.retrofit

import com.joelgh.movies_2022.data.remote.RemoteDataSource
import com.joelgh.movies_2022.domain.MovieModel

class MoviesRetrofitRemoteSource(private val apiClient: ApiClient) : RemoteDataSource{

    override fun getAll(): List<MovieModel> = apiClient.getAll()!!.map{it.toDomain()}

    override fun findById(movieId: String): MovieModel? = apiClient.findById(movieId)?.toDomain()
}