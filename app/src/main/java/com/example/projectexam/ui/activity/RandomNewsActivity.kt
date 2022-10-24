package com.example.projectexam.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectexam.databinding.ActivityRandomNewsBinding

class RandomNewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRandomNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}