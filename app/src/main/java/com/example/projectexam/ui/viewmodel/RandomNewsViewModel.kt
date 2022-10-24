package com.example.projectexam.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectexam.data.remote.NewsRemoteDataSource
import com.example.projectexam.data.repository.NewsRepository
import com.example.projectexam.data.service.NewsService
import com.example.projectexam.retrofit.NewsRetrofit
import com.example.projectexam.ui.model.news.Article
import com.example.projectexam.ui.model.news.NewsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class RandomNewsViewModel @Inject constructor(
    private val  newsRepository: NewsRepository
): ViewModel() {
    private var randomNewsLiveData = MutableLiveData<List<NewsResponse>>()
    private val compositeDisposable = CompositeDisposable()
    private val verifyApiResponseLiveData = MutableLiveData<NewsResponse>()
    private val listArticleLiveData = MutableLiveData<List<Article>>()

//    private var newsService: NewsService = NewsRetrofit.newsService
//    private var newsRemoteDataSource: NewsRemoteDataSource = NewsRemoteDataSource(newsService)
//    private var newsRepository: NewsRepository = NewsRepository(newsRemoteDataSource)

    fun verifyApi(key: String) {
        compositeDisposable.add(
            newsRepository.verifyApi(key)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<NewsResponse>() {
                    override fun onSuccess(t: NewsResponse) {
                        verifyApiResponseLiveData.value = t
                        listArticleLiveData.value = t.articles
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }

    fun getVerifyApiResponseLiveData(): MutableLiveData<List<Article>>  = listArticleLiveData

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }

//    fun getRandomNewsLiveData(): MutableLiveData<NewsResponse> = randomNewsLiveData
//    fun getRandomNewsLiveData(): MutableLiveData<List<NewsResponse>> {
//        return randomNewsLiveData
//    }
//    override fun onCleared() {
//        super.onCleared()
//        compositeDisposable.clear()
//        compositeDisposable.dispose()
//    }

}