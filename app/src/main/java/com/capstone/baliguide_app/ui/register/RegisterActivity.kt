package com.capstone.baliguide_app.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.capstone.baliguide_app.R
import com.capstone.baliguide_app.databinding.ActivityLoginBinding
import com.capstone.baliguide_app.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.edRegisterPassword.inputType = 129
        binding.progressBar.visibility = View.GONE

        binding.edRegisterPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.count() < 8) {
                    binding.registerButton.isEnabled = false
                }
                else {
                    binding.registerButton.isEnabled = true
                }
            }
            override fun afterTextChanged(s: Editable) {
                // Do nothing.
            }
        })

        binding.loginClickable.setOnClickListener {
            finish()
        }
    }
}