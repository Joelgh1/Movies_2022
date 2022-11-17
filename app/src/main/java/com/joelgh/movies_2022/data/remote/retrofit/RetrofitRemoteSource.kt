package com.joelgh.movies_2022.data.remote.retrofit

import com.joelgh.movies_2022.data.remote.RemoteDataSource
import com.joelgh.movies_2022.domain.MovieModel

class RetrofitRemoteSource(private val apiClient: ApiClient) : RemoteDataSource{

    override suspend fun getAll(): List<MovieModel> = apiClient.getAll()!!.map{it.toDomain()}

    override suspend fun findById(movieId: String): MovieModel? = apiClient.findById(movieId)?.toDomain()
}