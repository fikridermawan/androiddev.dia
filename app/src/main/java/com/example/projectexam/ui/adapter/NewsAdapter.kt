package com.example.projectexam.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projectexam.databinding.ItemNewsBinding
import com.example.projectexam.ui.model.news.Article
import com.example.projectexam.ui.model.news.NewsResponse

class NewsAdapter(private var NewsModel: List<Article>):
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    var onItemClick: ((Article) -> Unit)? = null
    inner class ViewHolder(var binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {

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
        val NewsModel = NewsModel [position]
        with(holder) {
            Glide.with(binding.ivNews.context).load(NewsModel.urlToImage).into(binding.ivNews)
            binding.tvName.text = NewsModel.author
            binding.tvTitle.text = NewsModel.title

        }
    }

    override fun getItemCount(): Int {
        return NewsModel.size
    }
}