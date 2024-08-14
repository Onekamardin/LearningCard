package com.example.learningcard.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learningcard.data.model.Dict
import kotlinx.coroutines.flow.Flow

@Dao
interface DictDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDict(dict: Dict): Long

    @Query("SELECT * FROM dict ORDER BY title")
    fun getAllDictionaries(): List<Dict>

    @Query("SELECT * FROM dict ORDER BY title LIMIT 1")
    fun getFirstDict(): Dict


}