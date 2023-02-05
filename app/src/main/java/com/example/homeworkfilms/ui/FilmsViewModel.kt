package com.example.homeworkfilms.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homeworkfilms.domain.Repository
import com.example.homeworkfilms.domain.UiItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _liveData = MutableLiveData<List<UiItem>>()
    val liveData: LiveData<List<UiItem>> get() = _liveData

    fun getFilms() {
        _liveData.value = repository.getFilms()
    }
}