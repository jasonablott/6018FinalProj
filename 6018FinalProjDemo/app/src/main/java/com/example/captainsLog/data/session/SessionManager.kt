package com.example.captainsLog.data.session

import android.content.Context
import android.content.SharedPreferences


class SessionManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("session_prefs", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        prefs.edit().putString("token", token).apply()
    }

    fun getToken(): String? = prefs.getString("token", null)

    fun clearSession() {
        prefs.edit().clear().apply()
    }
}
