package com.mestabn.psp_playground.ut02.exercise02.app

import com.mestabn.psp_playground.ut02.exercise02.data.remote.AlertApiModel
import com.mestabn.psp_playground.ut02.exercise02.data.remote.ApiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiEndPoint {
    @GET("alerts")
    suspend fun getAlerts(): Response<ApiResponse<List<AlertApiModel>>>

    @GET("alerts/{alert_id}")
    suspend fun getAlert(@Path("alert_id") alertId: String): Response<ApiResponse<AlertApiModel>>

}