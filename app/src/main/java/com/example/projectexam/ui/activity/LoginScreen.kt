package com.example.projectexam.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projectexam.databinding.ActivityLoginScreenBinding

class LoginScreen : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding
//    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        button = findViewById(R.id.btnLogin)
        binding.btnLogin.setOnClickListener {
            Toast.makeText(this@LoginScreen, "Login!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@LoginScreen, MainActivity::class.java)
            startActivity(intent)
        }
    }
}