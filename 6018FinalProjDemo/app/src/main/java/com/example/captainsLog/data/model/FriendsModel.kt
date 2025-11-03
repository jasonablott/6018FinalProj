package com.example.captainsLog.data.model

// Data classes representing a Friend, and a FeedItem
data class Friend(val id: String, val name: String, val profileUrl: String?, val status: String)
data class FeedItem(val user: String, val transcription: String, val timestamp: String)
data class FriendsState(
    val friends: List<Friend> = emptyList(),
    val feed: List<FeedItem> = emptyList(),
    val pending: List<String> = emptyList()
)
