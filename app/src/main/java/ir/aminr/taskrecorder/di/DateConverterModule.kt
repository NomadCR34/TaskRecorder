package ir.aminr.taskrecorder.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.aminr.taskrecorder.util.DateConverter
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DateConverterModule {

    @Provides
    @Singleton
    fun provideDateConverter():DateConverter = DateConverter()

}