package com.capstone.baliguide_app.ui.culinary

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
import com.capstone.baliguide_app.data.apiresponse.FoodItem
import com.capstone.baliguide_app.data.model.WisataDummy
import com.capstone.baliguide_app.databinding.ActivityCulinaryResultBinding
import com.capstone.baliguide_app.ui.homepage.HomepageActivity

class CulinaryResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCulinaryResultBinding
    private val list = ArrayList<WisataDummy>()
    private val viewModel: CulinaryViewModel by viewModels()

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
        super.setTitle(R.string.culinary_result_toolbar_title)
        binding = ActivityCulinaryResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.listCulinary.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.listCulinary.addItemDecoration(itemDecoration)

        viewModel.culinaryResponse.observe(this, { getFoods ->
            getCulinaryResults(getFoods as List<FoodItem>)
        })

        viewModel.isLoading.observe(this, {
            showLoading(it)
        })
    }

    private fun getCulinaryResults(ListCafe: List<FoodItem>) {
        val adapter = ListCulinaryAdapter(ListCafe)
        binding.listCulinary.adapter = adapter
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}