package com.example.learningcard.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.learningcard.data.dao.WordDao
import com.example.learningcard.data.model.WordItem

@Database(entities = [WordItem::class], version = 1)
abstract class LearningDataBase : RoomDatabase() {

    abstract val wordDao: WordDao
}