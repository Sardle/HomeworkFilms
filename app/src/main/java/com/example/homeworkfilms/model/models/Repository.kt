package com.example.homeworkfilms.model.models

interface Repository {

    fun getFilms(): List<UiItem>
}