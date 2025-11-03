package com.example.captainsLog.data.repository

import com.example.captainsLog.data.api.LogsApi


/*
This class represents the logs repository which communicates with the API to
get all data necessary for the friends view.
 */
class LogsRepository(private val api: LogsApi) {
    suspend fun getLogs() = runCatching { api.getLogs() }
    suspend fun deleteLog(id: String) = runCatching { api.deleteLog(id) }
    suspend fun shareLog(id: String) = runCatching { api.shareLog(id) }
}
