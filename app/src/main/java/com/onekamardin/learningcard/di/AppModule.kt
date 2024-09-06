package com.onekamardin.learningcard.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.onekamardin.learningcard.data.dao.DictDao
import com.onekamardin.learningcard.data.dao.WordDao
import com.onekamardin.learningcard.data.db.LearningDataBase
import com.onekamardin.learningcard.data.repository.ImportRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.sync.Mutex
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDb(app: Application): LearningDataBase {
        return Room.databaseBuilder(app, LearningDataBase::class.java, "learning_db").build()
    }

    @Provides
    @Singleton
    fun provideWordDao(db: LearningDataBase): WordDao {
        return db.wordDao
    }

    @Provides
    @Singleton
    fun provideDictDao(db: LearningDataBase): DictDao {
        return db.dictDao
    }

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }
}

