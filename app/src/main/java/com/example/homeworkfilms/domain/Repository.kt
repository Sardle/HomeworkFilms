package com.example.homeworkfilms.domain

interface Repository {

    fun getFilms(): List<UiItem>
}