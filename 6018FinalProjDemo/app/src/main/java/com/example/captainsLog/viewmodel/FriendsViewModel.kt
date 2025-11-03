package com.example.captainsLog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.captainsLog.data.model.*
import com.example.captainsLog.data.repository.FriendsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.collections.emptyList


// FriendsState data class is used by the ViewModel to render the current data needed by the
// friendsDisplay
data class FriendsState(
    val friends: List<Friend> = emptyList(),
    val feed: List<FeedItem> = emptyList(),
    val pending: List<String> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)

/*
This viewModel class represents the business logic that the friends screen needs to interact with
relevant routes. It is not fully implemented for the demo.
 */
class FriendsViewModel(private val repository: FriendsRepository) : ViewModel() {

    private val _state = MutableStateFlow(FriendsState(loading = true))
    val state: StateFlow<FriendsState> = _state

    init {
        loadFriends()
    }

    fun loadFriends() {
        viewModelScope.launch {
            _state.value = FriendsState(loading = true)

            val friendsResult = repository.getFriends()
            val feedResult = repository.getFeed()

            _state.value = FriendsState(
                friends = friendsResult.getOrElse { emptyList() },
                feed = feedResult.getOrElse { emptyList() },
                loading = false,
                error = friendsResult.exceptionOrNull()?.message
                    ?: feedResult.exceptionOrNull()?.message
            )
        }
    }

    fun sendFriendRequest(userId: String) {
        viewModelScope.launch {
            repository.sendFriendRequest(userId)
            val updatedPending = _state.value.pending + userId
            _state.value = _state.value.copy(pending = updatedPending)
        }
    }
}

