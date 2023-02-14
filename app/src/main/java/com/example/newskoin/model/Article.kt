package com.example.newskoin.model

import java.io.Serializable

data class Article(
    val author: String,
    val title: String,
    val description: String,
    val urlToImage:String,
    val publishedAt: String,
    val content: String,
): Serializable
