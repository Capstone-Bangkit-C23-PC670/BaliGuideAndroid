package com.capstone.baliguide_app.ui.souvenir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.baliguide_app.R
import com.capstone.baliguide_app.data.model.WisataDummy
import com.capstone.baliguide_app.databinding.ActivitySouvenirResultBinding
import com.capstone.baliguide_app.ui.homepage.HomepageActivity

class SouvenirResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySouvenirResultBinding
    private val list = ArrayList<WisataDummy>()

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
        super.setTitle(R.string.souvenir_result_toolbar_title)
        binding = ActivitySouvenirResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listSouvenir.setHasFixedSize(true)
        list.addAll(getListWisataDummy())
        showRecyclerList()
    }

    private fun getListWisataDummy(): ArrayList<WisataDummy> {
        val dataName = resources.getStringArray(R.array.dummy_data_name)
        val dataRatings = resources.getStringArray(R.array.dummy_data_ratings)
        val dataLocations = resources.getStringArray(R.array.dummy_data_location)
        val dataPrice = resources.getStringArray(R.array.dummy_data_price)
        val dataPhoto = resources.getStringArray(R.array.dummy_data_photo)
        val listWisata = ArrayList<WisataDummy>()
        for (i in dataName.indices) {
            val player = WisataDummy(dataName[i], dataRatings[i], dataLocations[i], dataPrice[i], dataPhoto[i])
            listWisata.add(player)
        }
        return listWisata
    }

    private fun showRecyclerList() {
        binding.listSouvenir.layoutManager = LinearLayoutManager(this)
        val adapter = ListSouvenirAdapter(list)
        binding.listSouvenir.adapter = adapter
    }
}