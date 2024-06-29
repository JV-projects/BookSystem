package com.booksystem.booksystemapp.repository

import android.util.Log
import com.booksystem.booksystemapp.model.Contato
import com.booksystem.booksystemapp.model.Tarefa
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class ContatoRepository {
    private val cliente = OkHttpClient()
    private val url = "https://androidkotlin-c7916-default-rtdb.firebaseio.com/"
    private val gson = Gson()
    private val logTag = "ContatoRepository"


    fun salvarContato(contato: Contato, sucesso: (Response) -> Unit,
                      falha: (IOException) -> Unit) {

        val contatoJson = gson.toJson(contato)

        val body = contatoJson.toRequestBody("application/json".toMediaTypeOrNull())

        val requisicao = Request.Builder()
            .url(url + "contatos.json")
            .post(body)
            .build()

        val resposta = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(logTag, "Falha na requisicao\n" +
                        "Call: $call\nException: ${e.localizedMessage}")
                falha(e)
            }

            override fun onResponse(call: Call, response: Response) {
                val respostaBody = response.body?.string().toString()
                Log.i(logTag, "Requisição feita com sucesso\n" +
                        "Call: $call\nResposta: $respostaBody")
                sucesso(response)
            }

        }
        cliente.newCall(requisicao).enqueue(resposta)
    }

    fun carregarContatos(sucesso: (Response, ArrayList<Contato>) -> Unit,
                         falha: (IOException) -> Unit) {

        var mapContatos: HashMap<String, Contato> = HashMap()

        val requisicao = Request.Builder()
            .url(url + "contatos.json")
            .get()
            .build()

        val resposta = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(logTag, "Falha na requisicao\n" +
                        "Call: $call\nException: ${e.localizedMessage}")
                falha(e)
            }

            override fun onResponse(call: Call, response: Response) {
                val respostaBody = response.body?.string().toString()
                Log.i(logTag, "Requisição feita com sucesso\n" +
                        "Call: $call\nResposta: $respostaBody")

                val typeToken = object : TypeToken<HashMap<String?, Contato?>?>() {}.type
                if (respostaBody != "null") {
                    mapContatos = gson.fromJson(respostaBody, typeToken)
                }

                val listaTemp = ArrayList<Contato>()

                mapContatos.keys.forEach {
                    val contato = mapContatos[it]
                    if (contato != null) {
                        contato.id = it
                        listaTemp.add(contato)
                    }
                }
                sucesso(response, listaTemp)
            }

        }

        cliente.newCall(requisicao).enqueue(resposta)

    }

    fun deletarContato(contato: Contato, sucesso: (Response) -> Unit,
                       falha: (IOException) -> Unit) {

        val requisicao = Request.Builder()
            .url("https://androidkotlin-c7916-default-rtdb.firebaseio.com/contatos/${contato.id}.json")
            .delete()
            .build()

        val resposta = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(logTag, "Falha na requisicao\n" +
                        "Call: $call\nException: ${e.localizedMessage}")
                falha(e)
            }

            override fun onResponse(call: Call, response: Response) {
                val respostaBody = response.body?.string().toString()
                Log.i(logTag, "Requisição feita com sucesso\n" +
                        "Call: $call\nResposta: $respostaBody")
                sucesso(response)
            }
        }
        cliente.newCall(requisicao).enqueue(resposta)
    }
}