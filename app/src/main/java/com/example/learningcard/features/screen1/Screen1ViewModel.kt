package com.example.learningcard.features.screen1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningcard.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Screen1ViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {



    fun getAllDictionaries() {
        viewModelScope.launch {
            repository.getAllDictionaries()
        }
    }

    fun getAllWordsByDictId(dictId: Long) {
        viewModelScope.launch {
            repository.getAllWordsByDictId(dictId)
        }
    }
}