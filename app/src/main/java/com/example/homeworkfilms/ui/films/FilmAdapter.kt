package com.example.homeworkfilms.ui.films

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkfilms.R
import com.example.homeworkfilms.domain.UiItem
import java.lang.Exception

class FilmAdapter(
    private val listFilmData: List<UiItem>,
    private val itemCLick: (String, String, Int) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            FILM_TYPE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.rv_item_films, parent, false)
                FilmViewHolder(view, itemCLick)
            }
            TITLE_TYPE -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.text_item, parent, false)
                TitleViewHolder(view)
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

    companion object {
        private const val TITLE_TYPE = 1
        private const val FILM_TYPE = 2
    }
}