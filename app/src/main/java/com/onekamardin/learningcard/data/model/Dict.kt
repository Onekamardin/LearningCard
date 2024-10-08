package com.onekamardin.learningcard.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "dict")
data class Dict(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long? = null,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "subtitle")
    val subtitle: String?,

    @ColumnInfo(name = "inside")
    val inside: Int,

    @ColumnInfo(name = "is_current")
    var current: Boolean,

    @ColumnInfo(name = "word_id")
    val wordId: Long,
) : Parcelable
