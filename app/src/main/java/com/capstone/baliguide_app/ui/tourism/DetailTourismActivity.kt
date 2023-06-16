package com.capstone.baliguide_app.ui.tourism

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.capstone.baliguide_app.R
import com.capstone.baliguide_app.data.apiresponse.TourismItem
import com.capstone.baliguide_app.data.model.WisataDummy
import com.capstone.baliguide_app.databinding.ActivityDetailTourismBinding
import com.capstone.baliguide_app.ui.homepage.HomepageActivity

class DetailTourismActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTourismBinding

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
        super.setTitle(R.string.tourism_detail_toolbar_title)
        binding = ActivityDetailTourismBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val wisata = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_PLAYER, TourismItem::class.java)
        }

        else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_PLAYER)
        }

        if (wisata != null) {
            binding.tvTitleName.text = wisata.name
            Glide.with(binding.imageView2)
                .load(wisata.imgURL)
                .into(binding.imageView2)
            binding.tvTitleLocation.text = "Location : " + wisata.location
            binding.tvTitleRating.text = "Ratings : " + wisata.rating
            binding.tvBudget.text = "Entrance Fee : " + wisata.entraceFee
        }

        else {
            binding.tvTitleName.text = "Wisatawan"
            Glide.with(binding.imageView2)
                .load("https://i.kym-cdn.com/entries/icons/original/000/040/897/cover6.jpg")
                .into(binding.imageView2)
            binding.tvTitleLocation.text = "Location " + "Jalan Kesedihan"
            binding.tvTitleRating.text = "Ratings : " + "10/10"
            binding.tvBudget.text = "Entrance Fee : " + "wisata.entraceFee"
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