package com.example.noticias.data.local

class DataBase {

    fun readDb() = _listFixe

    fun create(string: News)  = _listFixe.add(string)

    fun findItem(key: String)  = _listFixe.find { it.title == key }

    fun update(
        key: String,
        update: News
    ) {
        _listFixe.forEach { new ->
           if (new.title == key) {
               new.title = update.title
           }
       }
    }

    fun delete(
        key: String,
    ) {
       val newList = _listFixe.filter {it.title != key}
        _listFixe.clear()
        _listFixe = newList.toMutableList()
    }

    companion object {
        private var _listFixe:MutableList<News> = mutableListOf()
    }
}

data class News(
    var id:Int = 0,
    var title:String = "",
    var description:String = "",
    var message:String = "",
)