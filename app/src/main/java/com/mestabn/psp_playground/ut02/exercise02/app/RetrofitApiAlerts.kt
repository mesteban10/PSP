package com.mestabn.psp_playground.ut02.exercise02.app

import com.mestabn.psp_playground.ut02.exercise02.data.remote.AlertApiModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitApiAlerts : ApiAlert {

    private val urlEndPoint: String = "https://plagricola.sitehub.es/api/public/"
    private var apiEndPoint: ApiEndPoint

    init {
        apiEndPoint = buildApiService()
    }

    private fun buildApiService(): ApiEndPoint = buildClient().create(ApiEndPoint::class.java)


    private fun buildClient(): Retrofit = Retrofit.Builder()
        .baseUrl(urlEndPoint)
        //.client(buildHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    //Personalizar el tiempo que tarda el cliente en conectar con un servidor
    /*private fun buildHttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().also {
                it.level =
                    HttpLoggingInterceptor.Level.BODY //Si ponemos .NONE no nos muestra nada por consola
            })
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()*/


    override fun getAlerts(): List<AlertApiModel> {
        val call = apiEndPoint.getAlerts()
        val response = call.execute()
        return if (response.isSuccessful) {
            response.body()?.data ?: mutableListOf()

        } else {
            mutableListOf()
        }
    }
    override fun getAlert(alertId: String): AlertApiModel? {
        val call = apiEndPoint.getAlert(alertId)
        val response = call.execute()
        return if (response.isSuccessful) {
            response.body()?.data
        } else {
            null
        }
    }

}