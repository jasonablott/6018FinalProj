package com.example.captainsLog.ui.friends

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.captainsLog.viewmodel.FriendsViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*


// The friendsDisplay is the main view template for the friends view. It utilizes the FriendCard
// and FeedCard composables in it's layout.
@Composable
fun FriendsDisplay(
    viewModel: FriendsViewModel,
    navController: NavController
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Captain's Log Friends",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // friends section (horizontal)
        Text(
            text = "Friends",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        ) {
            items(state.friends) { friend ->
                FriendCard(friend)
            }
        }

        // feed section (vertical)
        Text(
            text = "Feed",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.feed) { feedItem ->
                FeedCard(feedItem)
            }
        }
    }
}