package com.example.captainsLog.data.repository

import com.example.captainsLog.data.api.FriendsApi


class FriendsRepository(private val api: FriendsApi) {
    suspend fun getFriends() = runCatching { api.getFriends() }
    suspend fun getFeed() = runCatching { api.getFeed() }
    suspend fun sendFriendRequest(id: String) = runCatching { api.sendFriendRequest(id) }
}
