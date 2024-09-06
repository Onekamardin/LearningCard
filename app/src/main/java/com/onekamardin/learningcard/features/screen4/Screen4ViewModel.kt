package com.onekamardin.learningcard.features.screen4

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onekamardin.learningcard.data.db.LearningDataBase
import com.onekamardin.learningcard.data.repository.ImportRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import javax.inject.Inject

@HiltViewModel
class Screen4ViewModel @Inject constructor(
    db: LearningDataBase,
    application: Application,
) : ViewModel() {

    private val importRepository = ImportRepository(
        provider = db,
        context = application,
        mutex = Mutex(),
        scope = viewModelScope,
        dispatcher = Dispatchers.IO
    )

    fun import() {
        viewModelScope.launch {
            importRepository.import()
        }
    }

}