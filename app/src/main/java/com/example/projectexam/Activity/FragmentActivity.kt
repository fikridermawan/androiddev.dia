package com.example.projectexam.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectexam.R

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }
}