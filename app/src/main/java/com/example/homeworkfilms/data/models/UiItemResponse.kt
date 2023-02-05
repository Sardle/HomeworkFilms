package com.example.homeworkfilms.data.models

sealed class UiItemResponse {
    data class FilmData(
        val id: Int? = null,
        val imageUrl: String? = null,
        val rating: String? = null,
        val name: String? = null,
        val isOscar: Boolean? = null,
        val description: String? = null
    ) : UiItemResponse()

    data class TitleItem(val title: String? = null) : UiItemResponse()
}
