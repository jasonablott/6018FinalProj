package com.example.captainsLog.data.api


interface RecordingApi {
    suspend fun upload(filePath: String): String
    suspend fun transcribe(filePath: String): String
}
