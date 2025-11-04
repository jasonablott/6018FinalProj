package com.example.captainsLog.viewmodel.providers

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.captainsLog.CaptainsLogApplication
import com.example.captainsLog.viewmodel.RecordViewModel


object RecordVMProvider {
    val Factory = viewModelFactory {
        initializer {
            val app = this[AndroidViewModelFactory.APPLICATION_KEY] as CaptainsLogApplication
            RecordViewModel()
        }
    }
}
