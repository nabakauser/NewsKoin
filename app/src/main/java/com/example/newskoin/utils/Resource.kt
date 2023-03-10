package com.example.newskoin.utils

class Resource<out T>(
    val status: Status,
    val data: T?
)
{
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data)
        }

        fun <T> error (msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data)
        }

        fun <T> loading (data: T?): Resource<T> {
            return Resource(Status.LOADING, data)
        }
    }
}