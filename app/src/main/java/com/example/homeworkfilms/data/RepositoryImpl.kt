package com.example.homeworkfilms.data

import com.example.homeworkfilms.data.mappers.UiItemMapper
import com.example.homeworkfilms.domain.Repository
import com.example.homeworkfilms.domain.UiItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val mapper: UiItemMapper,
    private val server: Server
) : Repository {

    override suspend fun getFilms(): List<UiItem> = withContext(Dispatchers.IO) {
        mapper(server.getFilms())
    }
}