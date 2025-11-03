package com.example.captainsLog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.captainsLog.data.model.AuthState
import com.example.captainsLog.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


/*
This viewModel class represents the business logic that the Auth screen needs to interact with
relevant routes. It is not fully implemented for the demo.
 */
class AuthViewModel(
    private val repo: AuthRepository
) : ViewModel() {

    private val _authState = MutableStateFlow(AuthState(false))
    val authState: StateFlow<AuthState> = _authState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            repo.login(email, password)
                .onSuccess { _authState.value = AuthState(true) }
                .onFailure { _authState.value = AuthState(false, it.message) }
        }
    }

    fun signup(email: String, password: String) {
        viewModelScope.launch {
            repo.signup(email, password)
                .onSuccess { _authState.value = AuthState(true) }
                .onFailure { _authState.value = AuthState(false, it.message) }
        }
    }
}
