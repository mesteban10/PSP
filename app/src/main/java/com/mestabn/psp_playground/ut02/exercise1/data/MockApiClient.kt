package com.mestabn.psp_playground.ut02.exercise1.data

class MockApiClient : ApiClient {
    override fun getUser(userId: Int): UserApiModel =
        UserApiModel(1, "Marta", "m1", "user1@gmail.com")


    override fun getUsers(): List<UserApiModel> = mutableListOf(
        UserApiModel(1, "Marta", "m1", "user1@gmail.com"),
        UserApiModel(2, "Juan", "j2", "user2@gmail.com"),
        UserApiModel(3, "Roberto", "r3", "user3@gmail.com"),
        UserApiModel(4, "Pepe", "p4", "user4@gmail.com")
    )

}