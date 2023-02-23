package com.example.homeworkfilms.ui.films

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homeworkfilms.databinding.RvItemFilmsBinding
import com.example.homeworkfilms.domain.UiItem

class FilmViewHolder(private val binding: RvItemFilmsBinding, private val itemCLick: (String, String, Int) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: UiItem.FilmData) {
        val number = binding.tvNumber
        val rating = binding.tvRating
        val image = binding.ivPoster
        val name = binding.tvFilmName
        val isOscar = binding.ivOscar

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