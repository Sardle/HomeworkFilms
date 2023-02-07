package com.example.homeworkfilms.ui.favorite_films

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkfilms.R
import com.example.homeworkfilms.domain.UiItem

class FavouriteFilmAdapter(
    private val listFilmData: List<UiItem.FilmData>,
    private val itemCLick: (String, String, Int) -> Unit
) : RecyclerView.Adapter<FavouriteFilmViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteFilmViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item_favorite_films, parent, false)
        return FavouriteFilmViewHolder(view, itemCLick)
    }

    override fun onBindViewHolder(holder: FavouriteFilmViewHolder, position: Int) {
        holder.onBind(listFilmData[position])
    }

    override fun getItemCount(): Int = listFilmData.size
}