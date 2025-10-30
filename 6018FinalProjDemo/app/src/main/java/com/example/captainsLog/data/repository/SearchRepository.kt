package com.example.captainsLog.data.repository

import com.example.captainsLog.data.api.SearchApi


class SearchRepository(private val api: SearchApi) {
    suspend fun search(query: String) = runCatching { api.search(query) }
}
