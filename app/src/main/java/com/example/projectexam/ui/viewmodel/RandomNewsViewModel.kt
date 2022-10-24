package com.example.projectexam.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectexam.data.remote.NewsRemoteDataSource
import com.example.projectexam.data.repository.NewsRepository
import com.example.projectexam.data.service.NewsService
import com.example.projectexam.retrofit.NewsRetrofit
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

//    private var newsService: NewsService = NewsRetrofit.newsService
//    private var newsRemoteDataSource: NewsRemoteDataSource = NewsRemoteDataSource(newsService)
//    private var newsRepository: NewsRepository = NewsRepository(newsRemoteDataSource)

    fun getRandomNews(number: Int){
        compositeDisposable.add(
            newsRepository.getRandomNews(number)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<NewsResponse>>(){
                    override fun onSuccess(t: List<NewsResponse>) {
                        randomNewsLiveData.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }


                })
        )

    }
//    fun getRandomNewsLiveData(): MutableLiveData<NewsResponse> = randomNewsLiveData
    fun getRandomNewsLiveData(): MutableLiveData<List<NewsResponse>> {
        return randomNewsLiveData
    }
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }

}