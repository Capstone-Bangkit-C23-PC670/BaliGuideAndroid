package com.capstone.baliguide_app.ui.cafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.capstone.baliguide_app.R
import com.capstone.baliguide_app.databinding.ActivityCafeBinding

class CafeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCafeBinding

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
        super.setTitle(R.string.cafe_act_toolbar_title)
        binding = ActivityCafeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener{
            val intent = Intent(this, CafeResultsActivity::class.java)
            startActivity(intent)
        }
    }
}