package com.example.newskoin.data

import com.example.newskoin.Constants.API_KEY
import com.example.newskoin.model.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadLines(@Query("country")country: String,
                     @Query("page")page: Int): Response<News>

}