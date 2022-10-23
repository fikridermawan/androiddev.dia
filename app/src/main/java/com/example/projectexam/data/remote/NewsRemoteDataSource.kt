package com.example.projectexam.data.remote

import com.example.projectexam.data.service.NewsService
import com.example.projectexam.ui.model.news.NewsResponse
import io.reactivex.Single

class NewsRemoteDataSource(private val newsService: NewsService) {
//    fun getRandomNews(): Single<NewsResponse> {
//        return newsService.getRandomNew()
//    }
    fun getRandomNews(number: Int): Single<List<NewsResponse>> {
        return newsService.getRandomNews(number)
    }

}