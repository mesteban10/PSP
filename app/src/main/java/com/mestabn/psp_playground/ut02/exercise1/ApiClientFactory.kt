package com.mestabn.psp_playground.ut02.exercise1

import com.mestabn.psp_playground.R
import com.mestabn.psp_playground.ut02.exercise1.data.ApiClient
import com.mestabn.psp_playground.ut02.exercise1.data.MockApiClient
import com.mestabn.psp_playground.ut02.exercise1.data.RetrofitApiClient

class ApiClientFactory {

    fun build(actionId: Int): ApiClient = when (actionId) {
        R.id.action_mock -> MockApiClient()
        R.id.action_api -> RetrofitApiClient()
        else -> MockApiClient()
    }

}