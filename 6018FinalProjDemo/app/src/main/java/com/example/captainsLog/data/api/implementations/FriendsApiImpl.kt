package com.example.captainsLog.data.api.implementations

import com.example.captainsLog.data.api.FriendsApi
import com.example.captainsLog.data.model.FeedItem
import com.example.captainsLog.data.model.Friend


class FriendsApiImpl : FriendsApi {
    override suspend fun getFriends(): List<Friend> {
        // TODO: Implement KTOR GET /friends/list
        TODO("Return list of user's friends")
    }

    override suspend fun getFeed(): List<FeedItem> {
        // TODO: Implement KTOR GET /feed
        TODO("Return user's feed items")
    }

    override suspend fun sendFriendRequest(id: String) {
        // TODO: Implement KTOR POST /friends/add
        TODO("Send friend request")
    }
}
