package com.capstone.baliguide_app.ui.hotel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.baliguide_app.R
import com.capstone.baliguide_app.data.apiresponse.HotelItem
import com.capstone.baliguide_app.data.model.WisataDummy
import com.capstone.baliguide_app.databinding.ActivityHotelResultBinding
import com.capstone.baliguide_app.ui.homepage.HomepageActivity

class HotelResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHotelResultBinding
    private val list = ArrayList<WisataDummy>()
    private val viewModel: HotelViewModel by viewModels()

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.back_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean = when(item.itemId) {
        R.id.home -> {
            val intent = Intent(this, HomepageActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            finish()
            true
        }
        else -> {
            true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setTitle(R.string.hotel_result_toolbar_title)
        binding = ActivityHotelResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.listHotel.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.listHotel.addItemDecoration(itemDecoration)

        viewModel.hotelResponse.observe(this, { getHotels ->
            getHotelResults(getHotels as List<HotelItem>)
        })

        viewModel.isLoading.observe(this, {
            showLoading(it)
        })

    }

    private fun getHotelResults(ListCafe: List<HotelItem>) {
        val adapter = ListHotelAdapter(ListCafe)
        binding.listHotel.adapter = adapter
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}