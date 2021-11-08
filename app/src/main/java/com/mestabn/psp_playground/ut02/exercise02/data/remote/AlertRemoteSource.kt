package com.mestabn.psp_playground.ut02.exercise02.data.remote

import com.mestabn.psp_playground.ut02.exercise02.app.ApiAlert
import com.mestabn.psp_playground.ut02.exercise02.app.MockApiAlerts
import com.mestabn.psp_playground.ut02.exercise02.domain.AlertModels

class AlertRemoteSource(private val apiAlert: ApiAlert) {

    fun getAlerts(): List<AlertModels> {
        val alertApiModel = apiAlert.getAlerts()
        return alertApiModel.map { apiModel -> apiModel.toDomainModel() }
    }

    fun getAlert(alertId : Int): AlertModels?{
        val alertApiModel = apiAlert.getAlert(alertId.toString())
        if (alertApiModel != null) {
            return alertApiModel.toDomainModel()
        }
        return null
    }

}