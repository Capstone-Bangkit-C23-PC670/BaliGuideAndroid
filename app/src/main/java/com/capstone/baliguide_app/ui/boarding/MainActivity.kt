package com.capstone.baliguide_app.ui.boarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.baliguide_app.R
import com.capstone.baliguide_app.context.SuperApplication
import com.capstone.baliguide_app.databinding.ActivityMainBinding
import com.capstone.baliguide_app.ui.login.LoginActivity
import com.capstone.baliguide_app.ui.register.RegisterActivity

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener{
            finish()
            overridePendingTransition(0, 0)
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

        binding.buttonRegister.setOnClickListener{
            finish()
            overridePendingTransition(0, 0)
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
    }
}