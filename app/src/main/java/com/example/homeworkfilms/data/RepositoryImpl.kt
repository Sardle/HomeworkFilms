package com.example.homeworkfilms.data

import com.example.homeworkfilms.data.mappers.UiItemMapper
import com.example.homeworkfilms.domain.Repository
import com.example.homeworkfilms.domain.UiItem
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val mapper: UiItemMapper,
    private val server: Server
) : Repository {

    override fun getFilms(): List<UiItem> = server.getFilms().map { mapper(it) }
}