package com.example.captainsLog.ui.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.captainsLog.ui.auth.LoginScreen
import com.example.captainsLog.ui.friends.FriendsDisplay
import com.example.captainsLog.ui.logs.LogsView
import com.example.captainsLog.ui.record.RecordScreen
import com.example.captainsLog.ui.search.SearchScreen
import com.example.captainsLog.viewmodel.*
import com.example.captainsLog.viewmodel.providers.*


// This composable represents the navigation bar at the bottom of all user screens. It uses the
// NavBar and NavItems in it's layout.
@Composable
fun AppNavHost(startDestination: String = "login") {
    val navController = rememberNavController()

    val showBottomBar = startDestination != "login"

    Scaffold(
        bottomBar = {
            if (navController.currentBackStackEntryAsState().value?.destination?.route != "login") {
                BottomNavigationBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
        ) {
            composable("login") {
                val vm: AuthViewModel = viewModel(factory = AuthVMProvider.Factory)
                LoginScreen(viewModel = vm, navController = navController)
            }
            composable("record") {
                val vm: RecordViewModel = viewModel(factory = RecordVMProvider.Factory)
                RecordScreen(viewModel = vm, navController = navController)
            }
            composable("search") {
                val vm: SearchViewModel = viewModel(factory = SearchVMProvider.Factory)
                SearchScreen(viewModel = vm, navController = navController)
            }
            composable("friends") {
                val vm: FriendsViewModel = viewModel(factory = FriendsVMProvider.Factory)
                FriendsDisplay(viewModel = vm, navController = navController)
            }
            composable("logs") {
                val vm: LogsViewModel = viewModel(factory = LogsVMProvider.Factory)
                LogsView(viewModel = vm, navController = navController)
            }
        }
    }
}
