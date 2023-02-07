package com.example.homeworkfilms.ui.films

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homeworkfilms.R
import com.example.homeworkfilms.domain.Repository
import com.example.homeworkfilms.domain.UiItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _liveData = MutableLiveData<List<UiItem>>()
    val liveData: LiveData<List<UiItem>> get() = _liveData

    private val _errorLiveData = MutableLiveData<Int>()
    val errorLiveData: LiveData<Int> get() = _errorLiveData

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData


    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        when (throwable) {
            is SocketTimeoutException -> _errorLiveData.value = R.string.fatal
            else -> _errorLiveData.value = R.string.unknown
        }
    }

    fun getFilms() {
        _loadingLiveData.value = true
        viewModelScope.launch(exceptionHandler) {
            _liveData.value = repository.getFilms()
            _loadingLiveData.value = false
        }
    }
}