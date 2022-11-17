package com.joelgh.movies_2022.data.remote.firebase

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.joelgh.movies_2022.data.remote.RemoteDataSource
import com.joelgh.movies_2022.data.remote.retrofit.MovieApiModel
import com.joelgh.movies_2022.data.remote.retrofit.toDomain
import com.joelgh.movies_2022.domain.MovieModel
import kotlinx.coroutines.tasks.await

class FirebaseRemoteSource : RemoteDataSource{

    private val database = Firebase.database.reference

    override suspend fun getAll(): List<MovieModel> = database.get().await().children.map { dataSnapshot ->
                dataSnapshot.getValue(MovieApiModel::class.java)!!.toDomain()
    }

    override suspend fun findById(movieId: String): MovieModel? = database.child(movieId.toString()).get()
        .await().getValue(MovieApiModel::class.java)?.toDomain()


}