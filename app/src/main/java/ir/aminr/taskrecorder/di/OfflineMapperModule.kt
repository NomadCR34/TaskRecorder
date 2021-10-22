package ir.aminr.taskrecorder.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.aminr.taskrecorder.db.mapper.OfflineTaskMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OfflineMapperModule {

    @Provides
    @Singleton
    fun provideTaskOfflineMapper(): OfflineTaskMapper =
        OfflineTaskMapper()
}