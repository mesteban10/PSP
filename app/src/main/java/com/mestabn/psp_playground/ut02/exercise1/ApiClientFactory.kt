package com.mestabn.psp_playground.ut02.exercise1

import com.mestabn.psp_playground.R
import com.mestabn.psp_playground.ut02.exercise1.data.ApiClient
import com.mestabn.psp_playground.ut02.exercise1.data.MockApiClient

class ApiClientFactory {

    fun build (actionId: Int): ApiClient {
        //Cuando pulsamos el botón, dependiendo del id llama a una clase u otra
        return when(actionId){
            R.id.action_mock -> MockApiClient()
            //R.id.action_api -> RetrofitApiClient()
            else -> MockApiClient()
        }

    }
}