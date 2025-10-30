package com.example.captainsLog.data.repository

import com.example.captainsLog.data.api.LogsApi


class LogsRepository(private val api: LogsApi) {
    suspend fun getLogs() = runCatching { api.getLogs() }
    suspend fun deleteLog(id: String) = runCatching { api.deleteLog(id) }
    suspend fun shareLog(id: String) = runCatching { api.shareLog(id) }
}
