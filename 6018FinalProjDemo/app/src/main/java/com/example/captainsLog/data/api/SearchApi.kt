package com.example.captainsLog.data.api

import com.example.captainsLog.data.model.SearchResult


interface SearchApi {
    suspend fun search(query: String): List<SearchResult>
}
