package com.example.projectexam.data.service

import com.example.projectexam.ui.model.news.NewsResponse
import com.example.projectexam.ui.viewmodel.RandomNewsViewModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsService {
//    @GET("/animals/rand")
//    fun getRandomNew(): Single<NewsResponse>
//
//    @GET("/animals/rand/{number}")
//    fun getRandomNews(@Path("number") number: Int): Single<List<NewsResponse>>

    //Query
//    @GET("/v2/everything?domains=wsj.com")
//    fun getRandomAnimals(@Query("domains") domains: String): Single<List<AnimalResponse>>
    @GET("/v2/everything?domains=wsj.com")
    fun verifyApi(
        @Query("apiKey") key: String
    ): Single<NewsResponse>
}