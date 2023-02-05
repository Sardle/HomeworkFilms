package com.example.homeworkfilms.data.mappers

import com.example.homeworkfilms.data.models.UiItemResponse
import com.example.homeworkfilms.domain.UiItem
import javax.inject.Inject

class UiItemMapper @Inject constructor() {

    operator fun invoke(response: UiItemResponse) = when (response) {
        is UiItemResponse.FilmData -> with(response) {
            UiItem.FilmData(
                id = id ?: 0,
                description = description.orEmpty(),
                imageUrl = imageUrl.orEmpty(),
                rating = rating.orEmpty(),
                name = name.orEmpty(),
                isOscar = isOscar ?: false,
            )
        }
        is UiItemResponse.TitleItem -> with(response) {
            UiItem.TitleItem(
                title = title.orEmpty()
            )
        }
    }
}