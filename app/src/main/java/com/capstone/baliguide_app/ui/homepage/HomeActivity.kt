package com.capstone.baliguide_app.ui.homepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.baliguide_app.R
import com.capstone.baliguide_app.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}