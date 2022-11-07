package com.joelgh.movies_2022.app.commons

import com.google.gson.Gson

interface KSerializer {
    fun <T> toJson(src: T, srcClass: Class<T>): String
    fun <T> fromJson(json: String, jsonClass: Class<T>): T
}

class gsonSerializer : KSerializer{

    val gson = Gson()

    override fun <T> toJson(src: T, srcClass: Class<T>): String = gson.toJson(src, srcClass)

    override fun <T> fromJson(json: String, jsonClass: Class<T>): T = gson.fromJson(json, jsonClass)


}