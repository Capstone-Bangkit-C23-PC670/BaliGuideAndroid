package com.capstone.baliguide_app.ui.souvenir

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capstone.baliguide_app.R
import com.capstone.baliguide_app.data.apiresponse.SouvenirItem
import com.capstone.baliguide_app.data.model.WisataDummy
import com.capstone.baliguide_app.ui.hotel.ListHotelAdapter

class ListSouvenirAdapter (private val listSouvenir: List<SouvenirItem>) : RecyclerView.Adapter<ListSouvenirAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cafe, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        Glide.with(holder.imgPhoto)
            .load(listSouvenir[position].imgUrl)
            .into(holder.imgPhoto)
        holder.tvName.text = listSouvenir[position].nama
        holder.tvRatings.text = listSouvenir[position].rating.toString()
        holder.tvLocation.text = listSouvenir[position].lokasi

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailSouvenirActivity::class.java)
            intentDetail.putExtra(DetailSouvenirActivity.EXTRA_PLAYER, listSouvenir[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listSouvenir.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.iv_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvRatings: TextView = itemView.findViewById(R.id.tv_item_ratings)
        val tvLocation: TextView = itemView.findViewById(R.id.tv_item_locations)
    }
}