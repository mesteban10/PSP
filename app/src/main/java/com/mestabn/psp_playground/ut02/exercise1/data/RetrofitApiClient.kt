package com.mestabn.psp_playground.ut02.exercise1.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClient : ApiClient {

    private val urlEndPoint: String = "https://jsonplaceholder.typicode.com/"
    private var apiEndPoint: ApiEndPoint

    init {
        apiEndPoint = buildApiService()
    }

    private fun buildApiService(): ApiEndPoint = buildClient().create(ApiEndPoint::class.java)


    private fun buildClient(): Retrofit = Retrofit.Builder()
        .baseUrl(urlEndPoint)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


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

