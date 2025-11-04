//package com.example.captainsLog.ui.record
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Mic
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import com.example.captainsLog.data.model.Log
//import com.example.captainsLog.viewmodel.RecordViewModel
//import androidx.compose.material.icons.filled.PlayArrow
//import androidx.compose.material.icons.filled.CloudUpload
//import androidx.compose.material.icons.filled.Translate

package com.example.captainsLog.ui.record

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.Delete
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

//@Composable
//fun RecordedLogCard(
//    isUploading: Boolean,
//    transcription: String?,
//    onPlay: () -> Unit,
//    onUpload: () -> Unit,
//    onTranscribe: () -> Unit
//) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp),
//        shape = MaterialTheme.shapes.medium,
//        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
//        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
//    ) {
//        Column(
//            modifier = Modifier.padding(16.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            Text(
//                text = "New Recording Ready",
//                style = MaterialTheme.typography.titleMedium,
//                color = MaterialTheme.colorScheme.primary
//            )
//
//            // Buttons row
//            Row(
//                horizontalArrangement = Arrangement.spacedBy(24.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                IconButton(onClick = onPlay) {
//                    Icon(
//                        imageVector = Icons.Filled.PlayArrow,
//                        contentDescription = "Play Recording",
//                        tint = MaterialTheme.colorScheme.primary
//                    )
//                }
//                IconButton(onClick = onUpload) {
//                    Icon(
//                        imageVector = Icons.Filled.CloudUpload,
//                        contentDescription = "Upload Recording",
//                        tint = Color(0xFF4CAF50)
//                    )
//                }
//                IconButton(onClick = onTranscribe) {
//                    Icon(
//                        imageVector = Icons.Filled.Translate,
//                        contentDescription = "Transcribe Recording",
//                        tint = MaterialTheme.colorScheme.secondary
//                    )
//                }
//            }
//
//            if (isUploading) {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    CircularProgressIndicator(
//                        modifier = Modifier.size(20.dp),
//                        strokeWidth = 2.dp
//                    )
//                    Text(
//                        text = "Uploading...",
//                        style = MaterialTheme.typography.bodySmall,
//                        modifier = Modifier.padding(start = 8.dp)
//                    )
//                }
//            }
//
//            transcription?.let {
//                Text(
//                    text = "Transcription: $it",
//                    style = MaterialTheme.typography.bodySmall,
//                    color = MaterialTheme.colorScheme.onSurfaceVariant
//                )
//            }
//        }
//    }
//}

@Composable
fun RecordedLogCard(
    isUploading: Boolean,
    transcription: String?,
    onPlay: () -> Unit,
    onUpload: () -> Unit,
    onTranscribe: () -> Unit,
    onDiscard: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 12.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "New Recording Ready",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            // Action buttons row
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onPlay) {
                    Icon(
                        imageVector = Icons.Filled.PlayArrow,
                        contentDescription = "Play Recording",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                IconButton(onClick = onUpload) {
                    Icon(
                        imageVector = Icons.Filled.CloudUpload,
                        contentDescription = "Upload Recording",
                        tint = Color(0xFF4CAF50)
                    )
                }
                IconButton(onClick = onTranscribe) {
                    Icon(
                        imageVector = Icons.Filled.Translate,
                        contentDescription = "Transcribe Recording",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
                IconButton(onClick = onDiscard) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Discard Recording",
                        tint = Color.Red
                    )
                }
            }

            if (isUploading) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        strokeWidth = 2.dp
                    )
                    Text(
                        text = "Uploading...",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }

            transcription?.let {
                Text(
                    text = "Transcription: $it",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}