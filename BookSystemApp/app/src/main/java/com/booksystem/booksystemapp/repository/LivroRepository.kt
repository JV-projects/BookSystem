package com.booksystem.booksystemapp.repository

import android.util.Log
import com.booksystem.booksystemapp.model.Livro
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class LivroRepository {
    var logtag: String = "LivroRepository"

    private var localhost: String = "localhost"
    private val cliente = OkHttpClient()
    private val gson = Gson()
    fun findAllByTitulo(titulo: String, token: String, sucesso: (Response, ArrayList<Livro>) -> Unit,
                        falha: (IOException) -> Unit) {
        val url = "http://${localhost}/booksystem/api/livros?titulo=$titulo"
        var body: String = ""
        val listaLivro = ArrayList<Livro>()
        val requisicao = Request.Builder()
            .get()
            .url(url)
            .build()

        val resposta = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(logtag,
                    "Falha ao carregar livros\ncall: $call\nException: ${e.localizedMessage}")
                falha(e)
            }

            override fun onResponse(call: Call, response: Response) {
                body = response.body?.string().toString()
                Log.i(logtag,
                    "Requisição bem sucedida\n" +
                            "Call: $call\n" +
                            "Resposta: $body")

                val typeToken = object : TypeToken<ArrayList<Livro>>() {}.type
                val listaTemp: ArrayList<Livro> = gson.fromJson(body, typeToken)
                listaLivro.addAll(listaTemp)
                sucesso(response, listaLivro)
            }

        }
        cliente.newCall(requisicao).enqueue(resposta)
    }
}