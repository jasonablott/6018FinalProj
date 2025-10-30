package com.example.captainsLog.data.api.implementations

import com.example.captainsLog.data.api.AuthApi
import com.example.captainsLog.data.model.User


class AuthApiImpl : AuthApi {
    override suspend fun login(email: String, password: String): User {
        // KTOR POST to /auth/login
        TODO("Implement network call")
    }

    override suspend fun signup(email: String, password: String): User {
        // KTOR POST to /auth/signup
        TODO("Implement network call")
    }
}
