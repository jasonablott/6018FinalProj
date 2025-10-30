package com.example.captainsLog.data.model


data class RecordingState(
    val isRecording: Boolean = false,
    val isUploading: Boolean = false,
    val transcription: String? = null
)

class AudioRecorder {
    fun startRecording() {}
    fun stopRecording() {}
}

class AudioPlayer {
    fun play(filePath: String) {}
    fun stop() {}
}
