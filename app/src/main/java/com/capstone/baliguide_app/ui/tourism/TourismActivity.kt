package com.capstone.baliguide_app.ui.tourism

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import com.capstone.baliguide_app.R
import com.capstone.baliguide_app.databinding.ActivityTourismBinding
import com.capstone.baliguide_app.ui.cafe.CafeResultsActivity

class TourismActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTourismBinding

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.back_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean = when(item.itemId) {
        R.id.back -> {
            finish()
            true
        }
        else -> {
            true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setTitle(R.string.tourism_act_toolbar_title)
        binding = ActivityTourismBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // Do nothing
            }
            override fun afterTextChanged(s: Editable) {
                // Do nothing.
                val inputRatings = binding.inputRatings.text.toString()
                val inputBudget = binding.inputBudget.text.toString()
                val inputLocation = binding.inputLocation.text.toString()

                if (inputRatings.isNotEmpty() && inputBudget.isNotEmpty() && inputLocation.isNotEmpty()) {
                    binding.registerButton.isEnabled = true
                }
            }
        }

        binding.inputRatings.addTextChangedListener(textWatcher)
        binding.inputBudget.addTextChangedListener(textWatcher)
        binding.inputLocation.addTextChangedListener(textWatcher)

        binding.registerButton.setOnClickListener{
            val intent = Intent(this, TourismResultActivity::class.java)
            startActivity(intent)
        }
    }
}