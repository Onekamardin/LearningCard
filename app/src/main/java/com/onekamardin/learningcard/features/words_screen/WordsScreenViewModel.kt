package com.onekamardin.learningcard.features.words_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onekamardin.learningcard.data.model.Dict
import com.onekamardin.learningcard.data.model.WordItem
import com.onekamardin.learningcard.data.repository.Repository
import com.onekamardin.learningcard.features.main.MainScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordsScreenViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _words = MutableStateFlow(emptyList<WordItem>())
    val words = _words.asStateFlow()

    private val _dictionary = MutableStateFlow(emptyList<Dict>())
    val dictionary = _dictionary.asStateFlow()


//    private val _screenState = MutableStateFlow<MainScreenState>(MainScreenState.FeedScreen)
//    val screenState = _screenState.asStateFlow()
//
//    private var savedState: MainScreenState = MainScreenState.FeedScreen
//
//    private fun showDictionariesScreen() {
//        savedState = _screenState.value
//        _screenState.value = MainScreenState.DictionariesScreen(_dictionary.value)
//    }
//
//    fun closeDictionariesScreen() {
//        _screenState.value = savedState
//    }

    var isBottomSheetOpened = MutableStateFlow(false)

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

    fun loadWords(dictId: Long) {
        viewModelScope.launch {
            repository.getAllWordsByDictId(dictId)
                .catch {
                    _words.value = emptyList<WordItem>()
                }
                .collect { value ->
                    _words.value = value
                }
        }
    }




    fun getAllWordsByDictId(dictId: Long) {
        viewModelScope.launch {
            repository.getAllWordsByDictId(dictId)
        }
    }
}