package com.example.captainsLog.data.api.implementations

import com.example.captainsLog.data.api.LogsApi
import com.example.captainsLog.data.model.Log


/*
This class imitates data returned from API calls for the demo. A real implementation would send
requests to api routes /get/logs, delete/logs/{id} and share/logs/{id}
 */
class LogsApiImpl : LogsApi {
    override suspend fun getLogs(): List<Log> {
        return listOf(
            // Demo data
            Log("1", "audio1.mp3", "Explored the new engine controls."),
            Log("2", "audio2.mp3", "Captain's log entry about mission status."),
            Log("3", "audio3.mp3", "Test log with sample transcription."),
            Log("4", "audio4.mp3", "Conducted engineering system checks."),
            Log("5", "audio5.mp3", "Crew meeting held regarding new mission parameters."),
            Log("6", "audio6.mp3", "Scanned nearby star systems for anomalies."),
            Log("7", "audio7.mp3", "Navigational calculations completed successfully."),
            Log("8", "audio8.mp3", "Crew morale is high; recreational activities logged.")
        )
    }

    override suspend fun deleteLog(id: String) {
        // no-op for demo
    }

    override suspend fun shareLog(id: String) {
        // no-op for demo
    }
}
