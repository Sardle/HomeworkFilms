package com.example.homeworkfilms.ui.favorite_films

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homeworkfilms.domain.Repository
import com.example.homeworkfilms.domain.UiItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _favouriteLiveData = MutableLiveData<List<UiItem.FilmData>>()
    val favouriteLiveData: LiveData<List<UiItem.FilmData>> get() = _favouriteLiveData

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData

    fun getFavouriteFilm() {
        _loadingLiveData.value = true
        viewModelScope.launch {
            _favouriteLiveData.value = repository.getUser()
            _loadingLiveData.value = false
        }
    }
}