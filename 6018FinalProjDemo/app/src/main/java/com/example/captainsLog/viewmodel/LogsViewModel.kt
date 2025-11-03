package com.example.captainsLog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.captainsLog.data.model.Log
import com.example.captainsLog.data.repository.LogsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


// LogsState data class is used by the ViewModel to render the current data needed by the
// LogsView
data class LogsState(
    val logs: List<Log> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)

/*
This viewModel class represents the business logic that the Auth screen needs to interact with
relevant routes. It is not fully implemented for the demo.
 */
class LogsViewModel(private val repo: LogsRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(LogsState(loading = true))
    val uiState: StateFlow<LogsState> = _uiState

    init {
        loadLogs()
    }

    fun loadLogs() {
        viewModelScope.launch {
            _uiState.value = LogsState(loading = true)
            val result = repo.getLogs()
            _uiState.value = result.fold(
                onSuccess = { LogsState(logs = it) },
                onFailure = { LogsState(error = it.message) }
            )
        }
    }

    fun deleteLog(id: String) {
        viewModelScope.launch {
            repo.deleteLog(id)
            _uiState.value = _uiState.value.copy(logs = _uiState.value.logs.filterNot { it.id == id })
        }
    }

    fun shareLog(id: String) {
        viewModelScope.launch {
            repo.shareLog(id)
            // Could show a Toast/snackbar in real app
        }
    }
}
