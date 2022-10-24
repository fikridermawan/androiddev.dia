package com.example.projectexam.data.repository

import com.example.projectexam.data.remote.NewsRemoteDataSource
import com.example.projectexam.ui.model.news.NewsResponse
import io.reactivex.Single
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsRemoteDataSource: NewsRemoteDataSource) {
//    fun getRandomNew(): Single<NewsResponse> {
//        return newsRemoteDataSource.getRandomNews()
//    }
//    fun getRandomNews(number: Int): Single<List<NewsResponse>> {
//        return newsRemoteDataSource.getRandomNews(number)
//    }
    fun verifyApi(key: String): Single<NewsResponse> = newsRemoteDataSource.verifyApi(key)
}