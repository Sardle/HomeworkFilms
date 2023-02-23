package com.example.homeworkfilms.ui.favorite_films

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkfilms.databinding.RvItemFavoriteFilmsBinding
import com.example.homeworkfilms.domain.UiItem

class FavouriteFilmAdapter(
    private val itemCLick: (String, String, Int) -> Unit
) : RecyclerView.Adapter<FavouriteFilmViewHolder>() {

    private val listFilmData = mutableListOf<UiItem.FilmData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteFilmViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvItemFavoriteFilmsBinding.inflate(layoutInflater, parent, false)
        return FavouriteFilmViewHolder(binding, itemCLick)
    }

    override fun onBindViewHolder(holder: FavouriteFilmViewHolder, position: Int) {
        holder.onBind(listFilmData[position])
    }

    fun setItems(items: List<UiItem.FilmData>) {
        listFilmData.clear()
        listFilmData.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = listFilmData.size
}