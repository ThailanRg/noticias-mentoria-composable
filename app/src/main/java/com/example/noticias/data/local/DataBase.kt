package com.example.noticias.data.local

class DataBase {

    fun readDb() = _listFixe

    fun createDb(string: News)  = _listFixe.add(string)

    fun findItem(string: String)  = _listFixe.find { it.title == string }

    fun update(
        identificador: String,
        update: News
    ) {
       _listFixe.forEach {
           if (it.title == identificador) {
               it.title = update.title
           }
       }
    }

    fun delete(
        identificador: String,
    ) {
       val newList = _listFixe.filter {it.title != identificador}
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