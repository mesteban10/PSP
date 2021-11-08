package com.mestabn.psp_playground.ut02.exercise02.domain

data class AlertModels(
    val id: String,
    val title: String,
    val type: Int,
    val summary: String,
    val datePublished: String,
    val body: String,
    val source: String,
    val files: List<FileModel>
)

data class FileModel(val name: String, val url: String)