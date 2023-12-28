package com.example.beginner.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.beginner.R
import com.example.beginner.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAboutBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnToBack.setOnClickListener {
            finish()
        }
    }
}