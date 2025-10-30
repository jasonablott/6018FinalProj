package com.example.captainsLog.data.model


data class AuthState(val isAuthenticated: Boolean, val error: String? = null)
data class User(val id: String, val email: String, val token: String)
