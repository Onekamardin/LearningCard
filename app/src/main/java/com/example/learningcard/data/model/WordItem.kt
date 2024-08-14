package com.example.learningcard.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_item")
class WordItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,

    val name: String,
    val translate: String,

    @ColumnInfo(name = "transcription")
    val transcription: String?,

    val isLearned: Boolean,
    val dictionaryId: Long
)