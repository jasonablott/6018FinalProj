package com.example.captainsLog.data.repository

import com.example.captainsLog.data.api.RecordingApi


class RecordingRepository(private val api: RecordingApi) {
    suspend fun uploadAudio(filePath: String) = runCatching { api.upload(filePath) }
    suspend fun transcribeAudio(filePath: String) = runCatching { api.transcribe(filePath) }
}
