package com.example.captainsLog.ui.record

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.captainsLog.viewmodel.RecordViewModel

@Composable
fun RecordScreen(
    viewModel: RecordViewModel,
    navController: NavController
) {
    val state by viewModel.uiState.collectAsState()
    var showCard by remember { mutableStateOf(false) }

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
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Text(
            text = "Record a New Log",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(top = 16.dp)
        )

        // Middle content
        if (showCard) {
            RecordedLogCard(
                isUploading = state.isUploading,
                transcription = state.transcription,
                onPlay = { viewModel.playRecording() },
                onUpload = { viewModel.uploadRecording() },
                onTranscribe = { viewModel.transcribeRecording() },
                onDiscard = { showCard = false }
            )
        } else {
            Spacer(modifier = Modifier.height(200.dp))
        }

        // Give more space below the content to lift the button higher
        Spacer(modifier = Modifier.weight(1f))

        // Record button — moved higher up
        Box(
            modifier = Modifier
                .padding(bottom = 120.dp) // ⬆️ increase this to move it up more
                .size(90.dp)
                .clip(CircleShape)
                .background(
                    if (state.isRecording)
                        Color.Red.copy(alpha = 0.7f)
                    else Color.Red
                )
                .clickable {
                    viewModel.toggleRecording()
                    if (state.isRecording) {
                        showCard = true
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Mic,
                contentDescription = "Record",
                tint = Color.White,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}
