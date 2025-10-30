package com.example.captainsLog.data.api.implementations

import com.example.captainsLog.data.api.LogsApi
import com.example.captainsLog.data.model.Log


class LogsApiImpl : LogsApi {
    override suspend fun getLogs(): List<Log> {
        // TODO: Implement KTOR GET /logs
        TODO("Return list of logs")
    }

    override suspend fun deleteLog(id: String) {
        // TODO: Implement KTOR DELETE /logs/{id}
        TODO("Delete log by ID")
    }

    override suspend fun shareLog(id: String) {
        // TODO: Implement KTOR POST /share
        TODO("Share log by ID")
    }
}
