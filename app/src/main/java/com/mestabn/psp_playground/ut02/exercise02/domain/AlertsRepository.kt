package com.mestabn.psp_playground.ut02.exercise02.domain

interface AlertsRepository {
    fun fetchAll(): List<AlertModels>
}