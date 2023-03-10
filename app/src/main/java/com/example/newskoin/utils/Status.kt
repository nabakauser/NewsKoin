package com.example.newskoin.utils

enum class Status {
    SUCCESS,
    ERROR,
    LOADING,
}

//difference between sealed and enum class
// enum class -> in case you provide a data type to enum class,
//          then all its parameters will be of the same data type
//sealed class -> restricts inheritance
//             -> allows to store different data types in parameters