package com.example.homeworkfilms.domain

interface Repository {

    suspend fun getFilms(): List<UiItem>
}