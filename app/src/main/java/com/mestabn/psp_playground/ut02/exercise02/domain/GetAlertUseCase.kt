package com.mestabn.psp_playground.ut02.exercise02.domain

class GetAlertUseCase(private val alertRepository: AlertsRepository) {

    suspend fun execute(alertId: String): AlertModels? {
        return alertRepository.fetch(alertId)
    }
}