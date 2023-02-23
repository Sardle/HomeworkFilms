package com.example.homeworkfilms.data.mappers

import com.example.homeworkfilms.data.models.UiItemResponse
import com.example.homeworkfilms.domain.UiItem
import javax.inject.Inject

class UiItemMapper @Inject constructor() {

    operator fun invoke(response: List<List<UiItemResponse>>): List<UiItem> {
        return response.flatMap { item ->
            listOf(UiItem.TitleItem(item[0].category ?: "null")) + item.map { mapToUi(it) }
        }
    }

    fun mapToUi(response: UiItemResponse): UiItem.FilmData = with(response) {
        UiItem.FilmData(
            id = id ?: 0,
            imageUrl = imageUrl.orEmpty(),
            rating = rating.orEmpty(),
            name = name.orEmpty(),
            isOscar = isOscar ?: false,
            description = description.orEmpty()
        )
    }
}