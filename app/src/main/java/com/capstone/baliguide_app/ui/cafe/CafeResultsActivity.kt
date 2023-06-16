package com.capstone.baliguide_app.ui.cafe

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
import com.capstone.baliguide_app.data.apiresponse.CafeItem
import com.capstone.baliguide_app.data.model.WisataDummy
import com.capstone.baliguide_app.databinding.ActivityCafeResultsBinding
import com.capstone.baliguide_app.ui.homepage.HomepageActivity

class CafeResultsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCafeResultsBinding
    private val list = ArrayList<WisataDummy>()
    private val viewModel: CafeViewModel by viewModels()


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
        super.setTitle(R.string.cafe_result_toolbar_title)
        binding = ActivityCafeResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.listCafe.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.listCafe.addItemDecoration(itemDecoration)

        viewModel.cafeResponse.observe(this, { getCafes ->
            getCafeResults(getCafes as List<CafeItem>)
        })

        viewModel.isLoading.observe(this, {
            showLoading(it)
        })

//        list.addAll(getListWisataDummy())
    }

    private fun getCafeResults(ListCafe: List<CafeItem>) {
        val adapter = ListCafeAdapter(ListCafe)
        binding.listCafe.adapter = adapter
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

//    private fun getListWisataDummy(): ArrayList<WisataDummy> {
//        val dataName = resources.getStringArray(R.array.dummy_data_name)
//        val dataRatings = resources.getStringArray(R.array.dummy_data_ratings)
//        val dataLocations = resources.getStringArray(R.array.dummy_data_location)
//        val dataPrice = resources.getStringArray(R.array.dummy_data_price)
//        val dataPhoto = resources.getStringArray(R.array.dummy_data_photo)
//        val listWisata = ArrayList<WisataDummy>()
//        for (i in dataName.indices) {
//            val player = WisataDummy(dataName[i], dataRatings[i], dataLocations[i], dataPrice[i], dataPhoto[i])
//            listWisata.add(player)
//        }
//        return listWisata
//    }

}