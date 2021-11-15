package com.mestabn.psp_playground.ut03.ex01.app

import com.mestabn.psp_playground.ut03.ex01.domain.UserApiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Abstracción del cliente que vamos a usar en la actividad.
 */
interface ApiClient {
    suspend fun getUsers(): List<UserApiModel>
}

/**
 * Uso de la librería Retrofit como cliente REST API.
 */
class RetrofitApiClient : ApiClient {

    private val urlEndPoint: String = "https://jsonplaceholder.typicode.com/"
    private var apiEndPoint: Ut03Ex01ApiEndPoint

    init {
        apiEndPoint = buildApiService()
    }

    /**
     * Creación del cliente con el Endpoint.
     * Definido por la librería Retrofit. Siempre es así.
     */
    private fun buildApiService(): Ut03Ex01ApiEndPoint {
        return buildClient().create(Ut03Ex01ApiEndPoint::class.java)
    }

    /**
     * Creación y configuración del cliente Retrofit.
     * Siempre es así.
     */
    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * Enpoint para obtener un listado de usuarios
     * @return List<UserPaiModel> listado de usuarios
     */
    override suspend fun getUsers(): List<UserApiModel> = withContext(Dispatchers.IO) {
        val response = apiEndPoint.getUsers()
        if (response.isSuccessful) {
            val users = response.body()
            //Si tiene usuarios los devuelvo, sino, devuelvo un listado vacío.
            users ?: mutableListOf()
        } else {
            mutableListOf()
        }
    }
}