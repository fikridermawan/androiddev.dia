package com.example.projectexam.di

import com.example.projectexam.data.remote.NewsRemoteDataSource
import com.example.projectexam.data.repository.NewsRepository
import com.example.projectexam.data.service.NewsService
import com.example.projectexam.retrofit.NewsRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NewsModule {

    @Provides
    @Singleton
    fun provideNewsService(): NewsService = NewsRetrofit.newsService

    @Provides
    @Singleton
    fun provideNewsRemoteDataSource(newsService: NewsService): NewsRemoteDataSource
    = NewsRemoteDataSource(newsService)

    @Provides
    @Singleton
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository
    = NewsRepository(newsRemoteDataSource)
}