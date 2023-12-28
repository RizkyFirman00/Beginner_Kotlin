package com.example.beginner.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beginner.HomeAdapter
import com.example.beginner.R
import com.example.beginner.databinding.ActivityMainBinding
import com.example.beginner.data.UnivData
import com.example.beginner.model.Univ

class MainActivity : AppCompatActivity() {
    private lateinit var homeAdapter: HomeAdapter
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.title = "Daftar Universitas"

        homeAdapter = HomeAdapter {
            navigateToDetailDataActivity(it)
        }

        binding.rvItem.adapter = homeAdapter
        binding.rvItem.layoutManager = LinearLayoutManager(this)

        val universitasData = UnivData.data
        homeAdapter.submitList(universitasData)

        binding.btnToProfile.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

    }

    private fun navigateToDetailDataActivity(univ: Univ) {
        val intent = Intent(this, UnivDetailActivity::class.java)
        intent.putExtra("universitas", univ)
        startActivity(intent)
    }
}