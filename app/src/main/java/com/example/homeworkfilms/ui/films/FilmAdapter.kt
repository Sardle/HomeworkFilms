package com.example.homeworkfilms.ui.films

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkfilms.databinding.RvItemFilmsBinding
import com.example.homeworkfilms.databinding.TextItemBinding
import com.example.homeworkfilms.domain.UiItem
import java.lang.Exception

class FilmAdapter(
    private val itemCLick: (String, String, Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listFilmData = mutableListOf<UiItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            FILM_TYPE -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RvItemFilmsBinding.inflate(layoutInflater, parent, false)
                FilmViewHolder(binding, itemCLick)
            }
            TITLE_TYPE -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TextItemBinding.inflate(layoutInflater, parent, false)
                TitleViewHolder(binding)
            }
            else -> throw Exception("Invalid Type!")
        }

    override fun getItemCount(): Int = listFilmData.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FilmViewHolder -> holder.onBind(listFilmData[position] as UiItem.FilmData)
            is TitleViewHolder -> holder.onBind(listFilmData[position] as UiItem.TitleItem)
        }
    }

    override fun getItemViewType(position: Int): Int = when (listFilmData[position]) {
        is UiItem.FilmData -> FILM_TYPE
        is UiItem.TitleItem -> TITLE_TYPE
    }

    fun setItems(items: List<UiItem>) {
        listFilmData.clear()
        listFilmData.addAll(items)
        notifyDataSetChanged()
    }

    companion object {
        private const val TITLE_TYPE = 1
        private const val FILM_TYPE = 2
    }
}