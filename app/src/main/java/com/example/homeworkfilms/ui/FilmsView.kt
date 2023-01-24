package com.example.homeworkfilms.ui

import com.example.homeworkfilms.model.models.UiItem

interface FilmsView {

    fun showFilms(server: List<UiItem>)
}