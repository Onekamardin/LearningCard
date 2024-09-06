package com.onekamardin.learningcard.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.onekamardin.learningcard.data.dao.DictDao
import com.onekamardin.learningcard.data.dao.WordDao
import com.onekamardin.learningcard.data.model.Dict
import com.onekamardin.learningcard.data.model.WordItem

@Database(entities = [WordItem::class, Dict::class], version = 3)
abstract class LearningDataBase : RoomDatabase() {

    abstract val wordDao: WordDao
    abstract val dictDao: DictDao
}