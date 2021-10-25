package com.mestabn.psp_playground.ut02.exercise1.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint {
    @GET("users")
    fun getUsers(): Call<List<UserApiModel>>  //Devuelve un listado de modelos definidos previamente (UserApiModel)

    @GET("users/{id}")
    fun getUser(@Path("id") userId: Int): Call<UserApiModel>

}