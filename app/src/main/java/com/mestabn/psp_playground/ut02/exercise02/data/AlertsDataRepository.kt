package com.mestabn.psp_playground.ut02.exercise02.data

import com.mestabn.psp_playground.ut02.exercise02.data.remote.AlertRemoteSource
import com.mestabn.psp_playground.ut02.exercise02.domain.AlertModels
import com.mestabn.psp_playground.ut02.exercise02.domain.AlertsRepository

class AlertsDataRepository(private val alertRemote: AlertRemoteSource) : AlertsRepository {

    override fun fetchAll(): List<AlertModels> {
        return alertRemote.getAlerts()
    }

}