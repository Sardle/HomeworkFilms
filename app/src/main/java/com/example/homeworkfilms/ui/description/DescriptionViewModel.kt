package com.example.homeworkfilms.ui.description

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homeworkfilms.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DescriptionViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    fun addFavouriteFilm(id: Int) {
        viewModelScope.launch {
            repository.addFilmToFavourite(id)
        }
    }

    fun checkFilm(id: Int): Boolean {
        return repository.checkFilm(id)
    }

    fun removeFilm(id: Int) {
        viewModelScope.launch {
            repository.removeFilmFromFavourite(id)
        }
    }
}