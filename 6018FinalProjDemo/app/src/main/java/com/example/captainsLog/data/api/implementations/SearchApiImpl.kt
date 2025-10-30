package com.example.captainsLog.data.api.implementations

import com.example.captainsLog.data.api.SearchApi
import com.example.captainsLog.data.model.SearchResult


class SearchApiImpl : SearchApi {
    override suspend fun search(query: String): List<SearchResult> {
        // TODO: Implement KTOR POST to /search
        TODO("Return list of relevant search results")
    }
}
