package com.example.projectexam.data.repository

import com.example.projectexam.data.remote.NewsRemoteDataSource
import com.example.projectexam.ui.model.news.NewsResponse
import io.reactivex.Single

class NewsRepository (private val newsRemoteDataSource: NewsRemoteDataSource) {
//    fun getRandomNew(): Single<NewsResponse> {
//        return newsRemoteDataSource.getRandomNews()
//    }
    fun getRandomNews(number: Int): Single<List<NewsResponse>> {
        return newsRemoteDataSource.getRandomNews(number)
    }
}