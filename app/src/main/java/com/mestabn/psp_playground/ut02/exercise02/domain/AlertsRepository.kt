package com.mestabn.psp_playground.ut02.exercise02.domain

interface AlertsRepository {
    suspend fun fetchAll(): List<AlertModels>
    suspend fun fetch(alertId: String): AlertModels?
}