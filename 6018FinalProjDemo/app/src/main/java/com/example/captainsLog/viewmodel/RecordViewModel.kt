package com.example.captainsLog.viewmodel

import androidx.lifecycle.ViewModel
import com.example.captainsLog.data.model.AudioPlayer
import com.example.captainsLog.data.model.AudioRecorder
import com.example.captainsLog.data.model.RecordingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecordViewModel : ViewModel() {

    private val recorder = AudioRecorder()
    private val player = AudioPlayer()

    private val _uiState = MutableStateFlow(RecordingState())
    val uiState = _uiState.asStateFlow()

    // Demo functions — purely visual state toggling
    fun toggleRecording() {
        if (_uiState.value.isRecording) {
            recorder.stopRecording()
            _uiState.value = _uiState.value.copy(isRecording = false)
        } else {
            recorder.startRecording()
            _uiState.value = _uiState.value.copy(isRecording = true)
        }
    }

    fun playRecording() {
        player.play("demo_file_path")
    }

    fun uploadRecording() {
        // Just fake an upload indicator
        _uiState.value = _uiState.value.copy(isUploading = true)
    }

    fun transcribeRecording() {
        // Pretend a transcription was generated
        _uiState.value = _uiState.value.copy(transcription = "This is a demo transcription.")
    }

    fun resetUpload() {
        _uiState.value = _uiState.value.copy(isUploading = false)
    }
}
