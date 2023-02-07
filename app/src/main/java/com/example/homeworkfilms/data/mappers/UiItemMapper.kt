package com.example.homeworkfilms.data.mappers

import com.example.homeworkfilms.data.models.UiItemResponse
import com.example.homeworkfilms.domain.UiItem
import javax.inject.Inject

class UiItemMapper @Inject constructor() {

    operator fun invoke(response: List<List<UiItemResponse>>): List<UiItem> {
        val listFilms = mutableListOf<UiItem>()
        for (i in response.indices) {
            listFilms.add(UiItem.TitleItem(response[i][0].category ?: "null"))
            for (j in response[i]) {
                listFilms.add(
                    (UiItem.FilmData(
                        id = j.id ?: 0,
                        imageUrl = j.imageUrl.orEmpty(),
                        rating = j.rating.orEmpty(),
                        name = j.name.orEmpty(),
                        isOscar = j.isOscar ?: false,
                        description = j.description.orEmpty()
                    ))
                )
            }
        }
        return listFilms
    }
}