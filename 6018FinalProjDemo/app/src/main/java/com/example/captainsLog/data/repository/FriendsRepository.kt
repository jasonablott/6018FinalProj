package com.example.captainsLog.data.repository

import com.example.captainsLog.data.api.FriendsApi


/*
This class represents the friends repository which communicates with the API to
get all data necessary for the friends view.
 */
class FriendsRepository(private val api: FriendsApi) {
    suspend fun getFriends() = runCatching { api.getFriends() }
    suspend fun getFeed() = runCatching { api.getFeed() }
    suspend fun sendFriendRequest(id: String) = runCatching { api.sendFriendRequest(id) }
}
