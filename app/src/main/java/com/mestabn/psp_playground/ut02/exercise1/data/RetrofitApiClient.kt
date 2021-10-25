package com.mestabn.psp_playground.ut02.exercise1.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClient : ApiClient {

    private val urlEndPoint: String = "https://jsonplaceholder.typicode.com/" //URL del proyecto
    private var apiEndPoint: ApiEndPoint  //Interfaz necesaria de retrofit

    init {
        apiEndPoint = buildApiService() //Creo en objeto retrofit
    }


    private fun buildApiService(): ApiEndPoint {
        return buildClient().create(ApiEndPoint::class.java) //llamo a retrofit, y la creo con la interfaz ApiEndPoint
    }


    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint) //Establezco URL de la API
            .addConverterFactory(GsonConverterFactory.create()) //Usamos GSon
            .build()
    }


    override fun getUsers(): List<UserApiModel> {
        val call = apiEndPoint.getUsers()
        val response = call.execute()
        return if (response.isSuccessful) {
            val users = response.body()
            users ?: mutableListOf()
        } else {
            mutableListOf()
        }
    }


    override fun getUser(userId: Int): UserApiModel? {
        val call = apiEndPoint.getUser(userId)
        val response = call.execute()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}

