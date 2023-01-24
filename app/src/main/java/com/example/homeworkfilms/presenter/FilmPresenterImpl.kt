package com.example.homeworkfilms.presenter

import com.example.homeworkfilms.model.models.Repository
import com.example.homeworkfilms.model.models.Server
import com.example.homeworkfilms.ui.FilmsView

class FilmPresenterImpl(private var view: FilmsView?) : FilmPresenter {
    private val repository: Repository = Server

    override fun getFilms() {
        view?.showFilms(repository.getFilms())
    }

    override fun onClear() {
        view = null
    }
}