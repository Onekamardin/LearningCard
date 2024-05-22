package com.example.learningcard.data.repository

import android.app.Application
import com.example.learningcard.data.dao.WordDao
import com.example.learningcard.data.db.LearningDataBase
import javax.inject.Inject

class Repository @Inject constructor(
    private val dao: WordDao
) {


}