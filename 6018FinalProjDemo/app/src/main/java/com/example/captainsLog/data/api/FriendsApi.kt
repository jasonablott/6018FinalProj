package com.example.captainsLog.data.api

import com.example.captainsLog.data.model.Friend
import com.example.captainsLog.data.model.FeedItem


interface FriendsApi {
    suspend fun getFriends(): List<Friend>
    suspend fun getFeed(): List<FeedItem>
    suspend fun sendFriendRequest(id: String)
}
