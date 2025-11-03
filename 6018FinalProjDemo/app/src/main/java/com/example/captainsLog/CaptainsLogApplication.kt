package com.example.captainsLog

import android.app.Application
import com.example.captainsLog.data.repository.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import com.example.captainsLog.data.session.SessionManager
import com.example.captainsLog.data.api.implementations.*


/*
This class initializes the application
 */
class CaptainsLogApplication : Application() {

    // coroutine scope tied to application lifetime to run suspend functions in
    private val appScope = CoroutineScope(SupervisorJob())
    // Initialize SessionManager (needed by AuthRepository)
    private val sessionManager by lazy { SessionManager(this) }

    // API clients
    private val authApi by lazy { AuthApiImpl() }
    private val recordingApi by lazy { RecordingApiImpl() }
    private val searchApi by lazy { SearchApiImpl() }
    private val friendsApi by lazy { FriendsApiImpl() }
    private val logsApi by lazy { LogsApiImpl() }

    // initialize repositories here
    val authRepository by lazy { AuthRepository(authApi, sessionManager) }
    val recordingRepository by lazy { RecordingRepository(recordingApi) }
    val searchRepository by lazy { SearchRepository(searchApi) }
    val friendsRepository by lazy { FriendsRepository(friendsApi) }
    val logsRepository by lazy { LogsRepository(logsApi) }
}
