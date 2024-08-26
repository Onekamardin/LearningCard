package com.example.learningcard.features.screen1

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningcard.data.model.Dict
import com.example.learningcard.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Screen1ViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _dictionary = MutableStateFlow(emptyList<Dict>())
    val dictionary = _dictionary.asStateFlow()

    fun loadDictionaries() {
        viewModelScope.launch {
            repository.getAllDictionaries()
                .catch {
                    _dictionary.value = emptyList<Dict>()
                }
                .collect { value ->
                    _dictionary.value = value
                }
        }
    }


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