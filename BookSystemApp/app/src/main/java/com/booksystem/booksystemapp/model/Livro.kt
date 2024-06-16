package com.booksystem.booksystemapp.model

data class Livro(
    val titulo: String,
    val autor: String,
    val editora: String,
    val ano: Int,
    val edicao: Int,
    val paginas: Int,
    val assuntos: List<String>,
    val isbn: Long,
    val status: String,
)