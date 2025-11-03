package com.example.captainsLog.data.repository

import com.example.captainsLog.data.api.AuthApi
import com.example.captainsLog.data.session.SessionManager
import com.example.captainsLog.data.model.User


/*
This class represents the repository that will be connected to the Authentication
server for user authentication actions
 */
class AuthRepository(
    private val api: AuthApi,
    private val sessionManager: SessionManager
) {
    suspend fun login(email: String, password: String): Result<User> = runCatching {
        val user = api.login(email, password)
        sessionManager.saveToken(user.token)
        user
    }

    suspend fun signup(email: String, password: String): Result<User> = runCatching {
        val user = api.signup(email, password)
        sessionManager.saveToken(user.token)
        user
    }
}
