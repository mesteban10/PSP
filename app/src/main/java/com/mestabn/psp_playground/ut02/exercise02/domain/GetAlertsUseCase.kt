package com.mestabn.psp_playground.ut02.exercise02.domain

class GetAlertsUseCase(private val alertRepository: AlertsRepository) {

    suspend fun execute(): List<AlertModels> {
        return alertRepository.fetchAll()
    }
}