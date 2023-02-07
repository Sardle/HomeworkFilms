package com.example.homeworkfilms.domain

sealed class UiItem {
    data class FilmData(
        val id: Int,
        val imageUrl: String,
        val rating: String,
        val name: String,
        val isOscar: Boolean,
        val description: String
    ) : UiItem()

    data class TitleItem(val title: String) : UiItem()
}
