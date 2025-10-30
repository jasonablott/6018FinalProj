package com.example.captainsLog.data.api

import com.example.captainsLog.data.model.Log


interface LogsApi {
    suspend fun getLogs(): List<Log>
    suspend fun deleteLog(id: String)
    suspend fun shareLog(id: String)
}
