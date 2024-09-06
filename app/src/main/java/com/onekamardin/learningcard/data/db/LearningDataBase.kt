package com.example.learningcard.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.learningcard.data.dao.DictDao
import com.example.learningcard.data.dao.WordDao
import com.example.learningcard.data.model.Dict
import com.example.learningcard.data.model.WordItem

@Database(entities = [WordItem::class, Dict::class], version = 2)
abstract class LearningDataBase : RoomDatabase() {

    abstract val wordDao: WordDao
    abstract val dictDao: DictDao
}