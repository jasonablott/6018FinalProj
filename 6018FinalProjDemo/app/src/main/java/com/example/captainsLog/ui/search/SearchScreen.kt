package com.example.captainsLog.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.captainsLog.ui.logs.LogCard
import com.example.captainsLog.viewmodel.SearchViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel,
    navController: NavController
) {
    var query by remember { mutableStateOf(TextFieldValue("")) }
    var results by remember { mutableStateOf(listOf<com.example.captainsLog.data.model.Log>()) }

    val gradient = Brush.verticalGradient(
        colors = listOf(
            MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
            MaterialTheme.colorScheme.background
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(16.dp)
    ) {
        // Header
        Text(
            text = "Search Logs",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Search bar
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Enter search term") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )

        // Search button
        Button(
            onClick = {
                // Populate a couple of dummy log cards for demo
                results = listOf(
                    com.example.captainsLog.data.model.Log(
                        id = "1",
                        transcription = "This is a sample log for '${query.text}'",
                        audioUrl = ""
                    ),
                    com.example.captainsLog.data.model.Log(
                        id = "2",
                        transcription = "Another log entry matching '${query.text}'",
                        audioUrl = ""
                    )
                )
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp)
        ) {
            Text("Search")
        }

        // Results list
        if (results.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(results) { log ->
                    LogCard(
                        log = log,
                        onDelete = { /* optional for demo */ },
                        onShare = { /* optional for demo */ },
                        onPlay = { /* optional for demo */ }
                    )
                }
            }
        }
    }
}

