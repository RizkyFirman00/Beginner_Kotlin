package com.example.beginner.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.beginner.databinding.ActivityUnivDetailBinding
import com.example.beginner.model.Univ

class UnivDetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityUnivDetailBinding.inflate(layoutInflater) }
    private lateinit var universitas: Univ
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val univ: Univ? = intent.getParcelableExtra("universitas")
        if (univ != null) {
            universitas = univ
            Glide.with(this)
                .load(univ.gambarUrl)
                .into(binding.ivGambar)
            binding.tvNama.text = univ.namaUniv
            binding.tvTahun.text = univ.tahunBerdiri
            binding.tvDeskripsi.text = univ.deskripsi
        }

        binding.btnToBack.setOnClickListener {
            finish()
        }

        binding.btnToShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            val shareText = "${universitas.namaUniv}\n" +
                    "Tahun Berdiri: ${universitas.tahunBerdiri}\n" +
                    "Deskripsi: ${universitas.deskripsi}"

            shareIntent.putExtra(Intent.EXTRA_TEXT, shareText)
            startActivity(Intent.createChooser(shareIntent, "Share using"))
        }
    }
}