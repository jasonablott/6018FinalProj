package com.example.captainsLog.data.api

import com.example.captainsLog.data.model.User


interface AuthApi {
    suspend fun login(email: String, password: String): User
    suspend fun signup(email: String, password: String): User
}
