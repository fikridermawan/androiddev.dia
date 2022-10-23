package com.example.projectexam.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projectexam.databinding.ItemNewsBinding
import com.example.projectexam.ui.model.news.NewsResponse

class NewsAdapter(private var NewsModel: List<NewsResponse>):
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener{
                // on click action
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsModel = NewsModel[position]
        with(holder){
            Glide.with(binding.ivNews.context).load(newsModel.imageLink).into(binding.ivNews)
            binding.tvName.text = newsModel.name
        }
    }

    override fun getItemCount(): Int {
        return NewsModel.size
    }
}