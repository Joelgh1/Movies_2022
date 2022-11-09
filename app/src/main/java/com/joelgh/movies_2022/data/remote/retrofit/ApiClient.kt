package com.joelgh.movies_2022.data.remote.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiClient {

    private val baseUrl = "https://movies-and-shows-api.cyclic.app/"
    private val apiEndPoints: ApiEndPoints

    init{
        apiEndPoints = buildClient().create()
    }

    private fun buildClient() = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(
        GsonConverterFactory.create()).build()

    fun getAll(): List<MovieApiModel>?{
        val call = apiEndPoints.getAll().execute()

        return if(call.isSuccessful) {
            call.body()
        }else{
            emptyList()
        }
    }

    fun findById(movieId: String): MovieApiModel?{
        val call = apiEndPoints.findById(movieId).execute()

        return if(call.isSuccessful) {
            call.body()
        }else{
            null
        }
    }
}