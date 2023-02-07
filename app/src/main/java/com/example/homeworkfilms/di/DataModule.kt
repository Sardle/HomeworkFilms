package com.example.homeworkfilms.di

import com.example.homeworkfilms.data.RepositoryImpl
import com.example.homeworkfilms.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun getFilms(impl: RepositoryImpl): Repository
}