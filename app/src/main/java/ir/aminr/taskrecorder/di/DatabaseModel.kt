package ir.aminr.taskrecorder.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.aminr.taskrecorder.db.AppDatabase
import ir.aminr.taskrecorder.db.dao.TaskDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModel {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        AppDatabase.databaseName
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideTaskDao(appDatabase: AppDatabase): TaskDao =
        appDatabase.getTaskDao()
}