package com.booksystem.booksystemapp.repository

import android.util.Log
import com.booksystem.booksystemapp.model.Credenciais
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException
import kotlin.math.log

class CredenciaisRepository {

    var logtag: String = "CredenciaisRepository"
    private var localhost: String = "localhost"
    val gson = Gson()
    val okhttp = OkHttpClient()
    fun newCredenciais(credenciais: Credenciais){

        val json = gson.toJson(credenciais);

        val body = json.toRequestBody("application/json".toMediaTypeOrNull())

        val req = Request.Builder()
            .post(body)
            .url("http://${localhost}/booksystem/auth/register")
            .build()

        val res = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(logtag, "call $call | Exception: ${e.localizedMessage}")
            }

            override fun onResponse(call: Call, response: Response) {
                val resposta = response.body
                Log.i(logtag, "call $call | \n Resposta: ${resposta}")
            }

        }

        okhttp.newCall(req).enqueue(res)

    }

    fun login(credenciais: Credenciais, sucess: (Response, String) -> Unit, fail: (IOException) -> Unit){
        val json = gson.toJson(credenciais);

        val body = json.toRequestBody("application/json".toMediaTypeOrNull())

        val req = Request.Builder()
            .post(body)
            .url("http://${localhost}/booksystem/auth/login")
            .build()

        val res = object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.i(logtag, "call $call | Exception: ${e.localizedMessage}")
            }

            override fun onResponse(call: Call, response: Response) {
                val resposta = response.body?.string().toString()
                Log.i(logtag, "call $call | \n Resposta: ${resposta}")

                sucess(response, resposta)
            }
        }
        okhttp.newCall(req).enqueue(res)



    }

}