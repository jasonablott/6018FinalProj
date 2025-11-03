package com.example.captainsLog.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavItem(
    val label: String,
    val route: String,
    val icon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem("Record", "record", Icons.Filled.Mic),
    BottomNavItem("Search", "search", Icons.Filled.Search),
    BottomNavItem("Friends", "friends", Icons.Filled.People),
    BottomNavItem("Logs", "logs", Icons.Filled.List)
)
