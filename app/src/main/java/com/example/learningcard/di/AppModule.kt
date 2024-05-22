package com.example.learningcard.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.learningcard.data.db.LearningDataBase
import com.example.learningcard.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
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
    fun provideRepository(db: LearningDataBase): Repository {
        return Repository(db.wordDao)
    }
}

