package com.capstone.baliguide_app.ui.tourism

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
import com.capstone.baliguide_app.data.apiresponse.TourismItem
import com.capstone.baliguide_app.data.model.WisataDummy
import com.capstone.baliguide_app.databinding.ActivityTourismResultBinding
import com.capstone.baliguide_app.ui.homepage.HomepageActivity

class TourismResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTourismResultBinding
    private val list = ArrayList<WisataDummy>()
    private val viewModel: TourismViewModel by viewModels()

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
        super.setTitle(R.string.tourism_result_toolbar_title)
        binding = ActivityTourismResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.listTourism.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.listTourism.addItemDecoration(itemDecoration)

        viewModel.tourismResponse.observe(this, { getTourism ->
            getTourismResults(getTourism as List<TourismItem>)
        })

        viewModel.isLoading.observe(this, {
            showLoading(it)
        })
    }

    private fun getTourismResults(ListCafe: List<TourismItem>) {
        val adapter = ListTourismAdapter(ListCafe)
        binding.listTourism.adapter = adapter
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}