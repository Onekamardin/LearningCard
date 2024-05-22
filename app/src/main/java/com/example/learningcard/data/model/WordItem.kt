package com.example.learningcard.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_item")
class WordItem(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val translate: String,
    val isLearned: Boolean,
    val dictionaryId: Int
)