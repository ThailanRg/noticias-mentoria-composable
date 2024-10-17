package com.example.noticias.data.local

class DataBase {

    fun readDb() = _listFixe

    fun createDb(string: String)  = _listFixe.add(string)

    companion object {
        private val _listFixe:MutableList<String> = mutableListOf()
    }
}