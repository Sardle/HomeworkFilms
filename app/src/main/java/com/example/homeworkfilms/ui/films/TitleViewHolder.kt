package com.example.homeworkfilms.ui.films

import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkfilms.databinding.TextItemBinding
import com.example.homeworkfilms.domain.UiItem

class TitleViewHolder(private val binding: TextItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: UiItem.TitleItem) {
        binding.text.text = item.title
    }
}