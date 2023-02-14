package com.example.newskoin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newskoin.utils.Resource
import com.example.newskoin.model.Article
import com.example.newskoin.repository.MainRepository
import com.example.newskoin.utils.NetworkHelper
import kotlinx.coroutines.launch

class NewsViewModel (
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val newsMutableLiveData = MutableLiveData<Resource<List<Article>>>()
    val newsLiveData: LiveData<Resource<List<Article>>>
        get() = newsMutableLiveData

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            newsMutableLiveData.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getAllNews().let {
                    if (it.isSuccessful) {
                        newsMutableLiveData.postValue(Resource.success(it.body()?.articles))
                    } else newsMutableLiveData.postValue(
                        Resource.error(
                            it.errorBody().toString(),
                            null
                        )
                    )
                }
            } else newsMutableLiveData.postValue(Resource.error("No internet connection", null))
        }
    }
}