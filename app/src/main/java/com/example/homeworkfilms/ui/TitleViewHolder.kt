package com.example.homeworkfilms.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkfilms.R
import com.example.homeworkfilms.domain.UiItem

class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(item: UiItem.TitleItem) {
        itemView.findViewById<TextView>(R.id.text).text = item.title
    }
}