package com.example.newskoin.repository

import com.example.newskoin.Constants.API_KEY
import com.example.newskoin.data.ApiService

class MainRepository (
    private val apiService: ApiService
) {

    suspend fun getAllNews() = apiService.getHeadLines(API_KEY,1)
}