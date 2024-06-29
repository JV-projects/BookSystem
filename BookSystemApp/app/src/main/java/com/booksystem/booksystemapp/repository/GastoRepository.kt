package com.booksystem.booksystemapp.repository

import android.util.Log
import com.booksystem.booksystemapp.model.Contato
import com.booksystem.booksystemapp.model.Gasto
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

class GastoRepository  {

    private val cliente = OkHttpClient()
    private val url = "https://androidkotlin-c7916-default-rtdb.firebaseio.com/"
    private val gson = Gson()
    private val logTag = "GastoRepository"


    fun salvarGasto(gasto: Gasto, sucesso: (Response) -> Unit,
                      falha: (IOException) -> Unit) {

        val gastoJson = gson.toJson(gasto)

        val body = gastoJson.toRequestBody("application/json".toMediaTypeOrNull())

        val requisicao = Request.Builder()
            .url(url + "gastos.json")
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

    fun carregarGastos(sucesso: (Response, ArrayList<Gasto>) -> Unit,
                         falha: (IOException) -> Unit) {

        var mapGastos: HashMap<String, Gasto> = HashMap()

        val requisicao = Request.Builder()
            .url(url + "gastos.json")
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

                val typeToken = object : TypeToken<HashMap<String?, Gasto?>?>() {}.type
                if (respostaBody != "null") {
                    mapGastos = gson.fromJson(respostaBody, typeToken)
                }

                val listaTemp = ArrayList<Gasto>()

                mapGastos.keys.forEach {
                    val gasto = mapGastos[it]
                    if (gasto != null) {
                        gasto.id = it
                        listaTemp.add(gasto)
                    }
                }
                sucesso(response, listaTemp)
            }

        }

        cliente.newCall(requisicao).enqueue(resposta)

    }

    fun deletarGasto(gasto: Gasto, sucesso: (Response) -> Unit,
                       falha: (IOException) -> Unit) {

        val requisicao = Request.Builder()
            .url("https://androidkotlin-c7916-default-rtdb.firebaseio.com/gastos/${gasto.id}.json")
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