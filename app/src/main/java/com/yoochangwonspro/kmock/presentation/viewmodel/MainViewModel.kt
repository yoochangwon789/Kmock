package com.yoochangwonspro.kmock.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoochangwonspro.kmock.data.model.Lecture
import com.yoochangwonspro.kmock.domain.GetLectureListUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val getLectureListUseCase: GetLectureListUseCase
) : ViewModel() {

    private var _lectureListLiveData = MutableLiveData<List<Lecture>>()
    val lectureListLiveData: LiveData<List<Lecture>> = _lectureListLiveData

    fun fetchData(): Job = viewModelScope.launch {
        _lectureListLiveData.postValue(getLectureListUseCase() ?: listOf())
    }
}