package com.example.projectexam.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.projectexam.ui.fragment.AppliFragment
import com.example.projectexam.ui.fragment.HomeFragment
import com.example.projectexam.ui.fragment.NewsFragment
import com.example.projectexam.ui.fragment.ProfileFragment
import com.example.projectexam.R
import com.example.projectexam.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragment(R.id.container, HomeFragment.newInstance("",""))

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.mnHome -> {
                    showFragment(R.id.container, HomeFragment.newInstance("", ""))

                }
                R.id.mnApplication -> {
                    showFragment(R.id.container, AppliFragment.newInstance("", ""))
                }
                R.id.mnNews -> {
                    showFragment(R.id.container, NewsFragment.newInstance("", ""))
                }
                R.id.mnProfile -> {
                    showFragment(R.id.container, ProfileFragment.newInstance("", ""))
                }
            }
            true
        }
    }

    fun showFragment(id: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(id, fragment).commit()
    }
}