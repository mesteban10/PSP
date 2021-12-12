package com.mestabn.psp_playground.ut02.exercise02.data.remote

import com.mestabn.psp_playground.ut02.exercise02.domain.AlertModels

data class AlertApiModel(
    val alert_id: String,
    val title: String,
    val summary: String,
    val type: String,
    val date: String
) {
    fun toDomainModel(): AlertModels = AlertModels(
        alert_id,
        title,
        type.toInt(),
        summary,
        date,
        "",
        "",
        emptyList()
    )
}