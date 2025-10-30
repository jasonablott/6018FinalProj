package com.example.captainsLog.viewmodel.providers

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.captainsLog.CaptainsLogApplication
import com.example.captainsLog.viewmodel.LogsViewModel


object LogsVMProvider {
    val Factory = viewModelFactory {
        initializer {
            val app = this[AndroidViewModelFactory.APPLICATION_KEY] as CaptainsLogApplication
            LogsViewModel(app.logsRepository)
        }
    }
}
