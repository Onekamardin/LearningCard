package com.example.learningcard.data.repository

import com.example.learningcard.data.dao.DictDao
import com.example.learningcard.data.dao.WordDao
import com.example.learningcard.data.model.Dict
import com.example.learningcard.data.model.WordItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(
    private val wordDao: WordDao,
    private val dictDao: DictDao
) {

    suspend fun getAllDictionaries(): Flow<List<Dict>> {
        return flow {
            emit(dictDao.getAllDictionaries())
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAllWordsByDictId(dictId: Long): Flow<List<WordItem>> {
        return flow {
            emit(wordDao.getAllWordsById(dictId))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun createDictionary(
        title: String, subtitle: String, inside: Int, current: Boolean, wordId: Long
    ): Flow<Long> {
        return flow {
            val dict = Dict(null, title, subtitle, inside, current, wordId)
            emit(dictDao.insertDict(dict))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun createWord(
        name: String,
        translate: String,
        transcription: String,
        isLearned: Boolean,
        dictionaryId: Long
    ): Flow<Long> {
        return flow {
            val word = WordItem(null, name, translate, transcription, isLearned, dictionaryId)
            emit(wordDao.insertWord(word))
        }.flowOn(Dispatchers.IO)
    }
}