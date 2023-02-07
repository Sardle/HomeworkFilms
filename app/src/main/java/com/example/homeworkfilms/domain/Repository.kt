package com.example.homeworkfilms.domain

interface Repository {

    suspend fun getFilms(): List<UiItem>

    suspend fun addFilmToFavourite(id: Int)

    fun checkFilm(id: Int): Boolean

    suspend fun removeFilmFromFavourite(id: Int)

    suspend fun getUser(): List<UiItem.FilmData>
}