package com.booksystem.booksystemapp.model

data class PerfilUsuario(
    val nome: String,
    val username: String,
    val cpf: String,
    val telefone: String,
    val cep: String,
    val rua: String,
    val numero: Int,
    val bairro: String,
    val cidade: String,
    val estado: String
)
