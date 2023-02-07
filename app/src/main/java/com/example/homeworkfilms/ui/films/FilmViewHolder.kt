package com.example.homeworkfilms.ui.films

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homeworkfilms.R
import com.example.homeworkfilms.domain.UiItem

class FilmViewHolder(itemView: View, private val itemCLick: (String, String, Int) -> Unit) :
    RecyclerView.ViewHolder(itemView) {
    fun onBind(item: UiItem.FilmData) {
        val number = itemView.findViewById<TextView>(R.id.tvNumber)
        val rating = itemView.findViewById<TextView>(R.id.tvRating)
        val image = itemView.findViewById<ImageView>(R.id.ivPoster)
        val name = itemView.findViewById<TextView>(R.id.tvFilmName)
        val isOscar = itemView.findViewById<ImageView>(R.id.ivOscar)

        number.text = item.id.toString()
        rating.text = item.rating
        getPoster(item.imageUrl, image)
        name.text = item.name
        isOscar.isVisible = item.isOscar

        itemView.setOnClickListener {
            itemCLick(item.name, item.description, item.id)
        }
    }

    private fun getPoster(url: String, image: ImageView) {
        Glide.with(image)
            .load(url)
            .into(image)
    }
}