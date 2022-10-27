package com.example.projectexam.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.projectexam.databinding.ActivityDetailNewsBinding
import com.example.projectexam.ui.model.news.Article
import com.example.projectexam.ui.viewmodel.RandomNewsViewModel

class DetailNewsActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail_news)
//    }
private lateinit var binding: ActivityDetailNewsBinding
    private val viewModel: RandomNewsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}