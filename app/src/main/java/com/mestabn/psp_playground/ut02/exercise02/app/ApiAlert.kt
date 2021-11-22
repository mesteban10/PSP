package com.mestabn.psp_playground.ut02.exercise02.app

import com.mestabn.psp_playground.ut02.exercise02.data.remote.AlertApiModel

interface ApiAlert {
    suspend fun getAlerts(): List<AlertApiModel>
    suspend fun getAlert(alertId: String): AlertApiModel?

}