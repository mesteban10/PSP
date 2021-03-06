package com.mestabn.psp_playground.ut02.exercise1.data

class UserRepository(private val apiClient: ApiClient) {

    fun getUser(userId: Int): UserApiModel? = apiClient.getUser(userId)

    fun getUsers(): List<UserApiModel> = apiClient.getUsers()

}