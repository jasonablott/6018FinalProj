package com.example.captainsLog.data.model


data class Log(val id: String, val audioUrl: String, val transcription: String)
data class LogsState(
    val logs: List<Log> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)
