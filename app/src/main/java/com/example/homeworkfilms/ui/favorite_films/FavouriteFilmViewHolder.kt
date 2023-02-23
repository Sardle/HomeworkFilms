package com.example.homeworkfilms.ui.favorite_films

import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homeworkfilms.databinding.RvItemFavoriteFilmsBinding
import com.example.homeworkfilms.domain.UiItem

class FavouriteFilmViewHolder(
    private val binding: RvItemFavoriteFilmsBinding,
    private val itemCLick: (String, String, Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(item: UiItem.FilmData) {
        val rating = binding.tvRatingFav
        val image = binding.ivPosterFav
        val name = binding.tvFilmNameFav
        val isOscar = binding.ivOscarFav

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