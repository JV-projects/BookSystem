package com.booksystem.booksystemapp.repository

import android.util.Log
import com.booksystem.booksystemapp.model.Tarefa
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class TarefaRepository {
    private val cliente = OkHttpClient()
    private val gson = Gson()
    private val url = "https://androidkotlin-c7916-default-rtdb.firebaseio.com/"
    private val logTag = "TarefaRepository"

    fun salvarTarefa(tarefa: Tarefa, sucesso: (Response) -> Unit,
                     falha: (IOException) -> Unit) {
        val tarefaJson = gson.toJson(tarefa)

        val body = tarefaJson.toRequestBody("application/json".toMediaTypeOrNull())

        val requisicao = Request.Builder()
            .url(url + "tarefas.json")
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

    fun carregarTarefas(sucesso: (Response, ArrayList<Tarefa>) -> Unit,
                        falha: (IOException) -> Unit) {

        var mapJson: HashMap<String, Tarefa> = HashMap()
        val requisicao = Request.Builder()
            .url(url + "tarefas.json")
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



                val typeToken = object : TypeToken<HashMap<String?, Tarefa?>?>() {}.type
                if (respostaBody != "null") {
                    mapJson = gson.fromJson(respostaBody, typeToken)
                }

                val listaTemp = ArrayList<Tarefa>()

                mapJson.keys.forEach {
                    val tarefa = mapJson[it]
                    if (tarefa != null) {
                        tarefa.id = it
                        listaTemp.add(tarefa)
                    }
                }
                sucesso(response, listaTemp)
            }

        }
        cliente.newCall(requisicao).enqueue(resposta)
    }

    fun deletarTarefa(tarefa: Tarefa, sucesso: (Response) -> Unit,
                      falha: (IOException) -> Unit) {


        val requisicao = Request.Builder()
            .url("https://androidkotlin-c7916-default-rtdb.firebaseio.com/tarefas/${tarefa.id}.json")
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