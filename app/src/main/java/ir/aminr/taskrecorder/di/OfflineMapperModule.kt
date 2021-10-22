package ir.aminr.taskrecorder.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.aminr.taskrecorder.db.mapper.TaskOfflineMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OfflineMapperModule {

    @Provides
    @Singleton
    fun provideTaskOfflineMapper(): TaskOfflineMapper =
        TaskOfflineMapper()
}