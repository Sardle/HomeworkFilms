package com.example.homeworkfilms.data

import com.example.homeworkfilms.data.mappers.UiItemMapper
import com.example.homeworkfilms.domain.UiItem
import kotlinx.coroutines.delay
import javax.inject.Inject

class User @Inject constructor(
    private val mapper: UiItemMapper,
    private val server: Server
) {

    private suspend fun getFilmById(id: Int): UiItem.FilmData? {
        val list = server.getFilms()
        for (i in list) {
            for (j in i) {
                if (j.id == id) {
                    return mapper.mapToUi(j)
                }
            }
        }
        return null
    }

    suspend fun addFilmToFavourite(id: Int) {
        getFilmById(id)?.let { listFavoriteFilm.add(it) }
    }

    fun checkFilm(id: Int): Boolean {
        for (i in listFavoriteFilm) {
            if (i.id == id) {
                return true
            }
        }
        return false
    }

    suspend fun removeFilmFromFavourite(id: Int) {
        listFavoriteFilm.remove(getFilmById(id))
    }

    suspend fun getUser(): List<UiItem.FilmData> {
        delay(3000)
        return listFavoriteFilm
    }

    companion object {
        private val listFavoriteFilm = mutableListOf<UiItem.FilmData>()
    }
}