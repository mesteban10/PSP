package com.mestabn.psp_playground.ut03.ex01.app

import com.mestabn.psp_playground.ut03.ex01.domain.UserApiModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * EndPoints de los servicios que se van a usar.
 * Es requisito de Retrofit crear esta interfaz.
 */
interface Ut03Ex01ApiEndPoint {
    @GET("users")
    suspend fun getUsers(): Response<List<UserApiModel>>

}