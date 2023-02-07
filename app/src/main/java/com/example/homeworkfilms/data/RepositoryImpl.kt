package com.example.homeworkfilms.data

import com.example.homeworkfilms.data.mappers.UiItemMapper
import com.example.homeworkfilms.domain.Repository
import com.example.homeworkfilms.domain.UiItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val mapper: UiItemMapper,
    private val server: Server,
    private val user: User
) : Repository {

    override suspend fun getFilms(): List<UiItem> = withContext(Dispatchers.IO) {
        mapper(server.getFilms())
    }

    override suspend fun addFilmToFavourite(id: Int) {
        user.addFilmToFavourite(id)
    }

    override fun checkFilm(id: Int): Boolean {
        return user.checkFilm(id)
    }

    override suspend fun removeFilmFromFavourite(id: Int) {
        user.removeFilmFromFavourite(id)
    }

    override suspend fun getUser(): List<UiItem.FilmData> {
        return user.getUser()
    }
}