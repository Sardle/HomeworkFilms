package com.example.homeworkfilms

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FilmViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun onBind(item: FilmData) {
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
    }


    private fun getPoster(url: String, image: ImageView) {
        Glide.with(image)
            .load(url)
            .into(image)
    }
}