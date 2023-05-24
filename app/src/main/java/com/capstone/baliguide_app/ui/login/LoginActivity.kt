package com.capstone.baliguide_app.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.capstone.baliguide_app.R
import com.capstone.baliguide_app.databinding.ActivityLoginBinding
import com.capstone.baliguide_app.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.edLoginPassword.inputType = 129
        binding.progressBar.visibility = View.GONE

        binding.edLoginPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.count() < 8) {
                    binding.loginButton.isEnabled = false
                }
                else {
                    binding.loginButton.isEnabled = true
                }
            }
            override fun afterTextChanged(s: Editable) {
                // Do nothing.
            }
        })

        binding.registerClickable.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}