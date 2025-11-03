package com.example.captainsLog.data.api.implementations

import com.example.captainsLog.data.api.FriendsApi
import com.example.captainsLog.data.model.FeedItem
import com.example.captainsLog.data.model.Friend


/*
This class imitates data returned from API calls for the demo. A real implementation would send
requests to api routes /friends and /feed.
 */
class FriendsApiImpl : FriendsApi {
    override suspend fun getFriends(): List<Friend> {
        // Demo data
        return listOf(
            Friend("1", "James Kirk", null, "Online"),
            Friend("2", "Spock", null, "Away"),
            Friend("3", "Leonard McCoy", null, "Busy"),
            Friend("4", "Montgomery Scott", null, "Online"),
            Friend("5", "Nyota Uhura", null, "Offline"),
            Friend("6", "Hikaru Sulu", null, "Online"),
            Friend("7", "Pavel Chekov", null, "Away")
        )
    }

    override suspend fun getFeed(): List<FeedItem> {
        return listOf(
            // Demo data
            FeedItem("Spock", "Fascinating discovery today.", "Stardate 2310.5"),
            FeedItem("Kirk", "Exploring new worlds!", "Stardate 2311.7"),
            FeedItem("McCoy", "Medical report completed.", "Stardate 2311.8"),
            FeedItem("Uhura", "Communications system upgraded.", "Stardate 2312.1"),
            FeedItem("Scott", "Engineering systems nominal.", "Stardate 2312.3"),
            FeedItem("Sulu", "Navigation course corrected.", "Stardate 2312.5"),
            FeedItem("Chekov", "Excited about new crew assignment!", "Stardate 2312.6")
        )
    }

    override suspend fun sendFriendRequest(id: String) {
        // no-op for demo
    }
}
