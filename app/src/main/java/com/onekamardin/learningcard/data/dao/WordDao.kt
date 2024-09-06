package com.onekamardin.learningcard.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.onekamardin.learningcard.data.model.WordItem
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(wordItem: WordItem): Long

    @Delete
    suspend fun deleteWord(wordItem: WordItem)

    @Query("SELECT * FROM word_item")
    fun getAllWords(): Flow<List<WordItem>>

    @Query("SELECT * FROM word_item WHERE id = :dictId")
    fun getAllWordsById(dictId: Long): List<WordItem>
}