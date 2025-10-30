package com.example.captainsLog.data.api.implementations

import com.example.captainsLog.data.api.RecordingApi


class RecordingApiImpl : RecordingApi {
    override suspend fun upload(filePath: String): String {
        // TODO: Implement KTOR POST to /upload
        TODO("Upload audio file and return URL")
    }

    override suspend fun transcribe(filePath: String): String {
        // TODO: Implement KTOR POST to /transcribe
        TODO("Send file for transcription and return text")
    }
}
