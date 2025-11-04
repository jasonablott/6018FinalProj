package com.example.captainsLog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.captainsLog.data.model.Log
import com.example.captainsLog.data.model.SearchResult
import com.example.captainsLog.data.repository.SearchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// UI state for SearchScreen
data class SearchState(
    val results: List<Log> = emptyList(),  // always Log for LogCard
    val loading: Boolean = false,
    val error: String? = null
)

class SearchViewModel(private val repo: SearchRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchState())
    val uiState: StateFlow<SearchState> = _uiState

    // Perform search
    fun searchLogs(query: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(loading = true)

            val result = repo.search(query) // returns Result<List<SearchResult>>

            _uiState.value = result.fold(
                onSuccess = { searchResults: List<SearchResult> ->
                    // Map SearchResult -> Log for LogCard
                    val logs: List<Log> = searchResults.map { sr ->
                        Log(
                            id = sr.id,
                            transcription = sr.snippet, // use snippet as demo transcription
                            audioUrl = ""               // placeholder
                        )
                    }
                    SearchState(results = logs)
                },
                onFailure = { error ->
                    SearchState(error = error.message)
                }
            )
        }
    }
}




