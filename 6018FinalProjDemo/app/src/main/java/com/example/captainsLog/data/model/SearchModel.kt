package com.example.captainsLog.data.model


data class SearchResult(val id: String, val title: String, val snippet: String)
data class QueryState(
    val query: String = "",
    val results: List<SearchResult> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)
