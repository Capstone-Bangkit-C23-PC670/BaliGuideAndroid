package com.capstone.baliguide_app.ui.cafe

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.capstone.baliguide_app.R
import com.capstone.baliguide_app.data.model.WisataDummy
import com.capstone.baliguide_app.databinding.ActivityDetailCafeBinding
import com.capstone.baliguide_app.ui.homepage.HomepageActivity

class DetailCafeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailCafeBinding

    companion object {
        const val EXTRA_PLAYER = "key_player"
    }

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
        super.setTitle(R.string.cafe_detail_toolbar_title)
        binding = ActivityDetailCafeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val wisata = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_PLAYER, WisataDummy::class.java)
        }

        else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_PLAYER)
        }

        if (wisata != null) {
            binding.tvCafeName.text = wisata.name
            Glide.with(binding.imageView2)
                .load(wisata.photo)
                .into(binding.imageView2)
            binding.tvCafeLocation.text = "Location " + wisata.location
            binding.tvCafeRating.text = "Ratings : " + wisata.ratings
            binding.tvCafePhonenumber.text = "Phonenumber : 0838-9892-1234"
            binding.tvCafeFacility.text = "Facilities : Wahana Arung Jeram"
            binding.tvCafeOpened.text = "Open at  : 08:00"
            binding.tvCafeClosed.text = "Close at : 21:00"
        }

        binding.goBackButton.setOnClickListener{
            finish()
        }

        binding.goHomeButton.setOnClickListener{
            val intent = Intent(this, HomepageActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            finish()
        }
    }
}