package com.mestabn.psp_playground.ut02

import retrofit2.Call
import retrofit2.http.GET

/**
 * EndPoints de los servicios que se van a usar.
 * Es requisito de Retrofit crear esta interfaz.
 */
interface ApiEndPoint {
    @GET("users")
    fun getUsers(): Call<List<UserApiModel>>  //Devuelve un listado de modelos definidos previamente (UserApiModel)

    @GET("posts")
    fun getPost(): Call<List<PostApiModel>>  //Devuelve un listado de modelos definidos previamente (UserApiModel)
}