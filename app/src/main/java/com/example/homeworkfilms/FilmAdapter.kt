package com.example.homeworkfilms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FilmAdapter(private val listFilmData: List<FilmData>): RecyclerView.Adapter<FilmViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_films, parent, false)
        return FilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.onBind(listFilmData[position])
    }

    override fun getItemCount(): Int = listFilmData.size
}