package com.onekamardin.learningcard.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.onekamardin.learningcard.data.model.Dict

@Dao
interface DictDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDict(dict: Dict): Long

    @Query("SELECT * FROM dict ORDER BY title")
    fun getAllDictionaries(): List<Dict>

    @Query("SELECT * FROM dict ORDER BY title LIMIT 1")
    fun getFirstDict(): Dict


}