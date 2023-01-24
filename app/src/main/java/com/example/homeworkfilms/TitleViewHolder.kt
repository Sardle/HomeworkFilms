package com.example.homeworkfilms

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkfilms.model.models.UiItem

class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(item: UiItem.TitleItem) {
        itemView.findViewById<TextView>(R.id.text).text = item.title
    }
}