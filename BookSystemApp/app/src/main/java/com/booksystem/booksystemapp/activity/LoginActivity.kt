package com.booksystem.booksystemapp.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.booksystem.booksystemapp.databinding.EntrarLayoutBinding
import com.booksystem.booksystemapp.model.Credenciais
import com.booksystem.booksystemapp.repository.CredenciaisRepository
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity(){

    lateinit var token: String
    private var credRep = CredenciaisRepository()
    private lateinit var binding : EntrarLayoutBinding
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = EntrarLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = binding.edtEmail
        val senha = binding.edtSenha

        binding.btnEntrar.setOnClickListener{ view ->

            if(username.text.toString().isEmpty() || senha.text.toString().isEmpty()){

                val snackbar = Snackbar.make(view, "Preencha todos os campos", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.DKGRAY)

                snackbar.show()

            }else {

                val c = Credenciais(username.text.toString(), senha.text.toString());
                credRep.login(c,
                    {response, resToken ->

                        if(response.code == 403){
                            val snackbar = Snackbar.make(view, "Email ou senha inválidos", Snackbar.LENGTH_SHORT)
                            snackbar.setBackgroundTint(Color.RED)
                            snackbar.show()
                        }else{
                            token = resToken
                            saveToken(token)
                            saveUsername(username.text.toString())
                            toCatalogo()}
                        },
                    {})
            }
        }

        binding.linkCadastrar.setOnClickListener{
            val intent = Intent(this, CadastrarActivity::class.java)
            startActivity(intent)
        }

    }
    fun saveToken(token: String){
        val sp = getSharedPreferences("session", Context.MODE_PRIVATE)
        sp.edit().apply{
            putString("token", token)
            commit()
        }
    }

    fun saveUsername(username: String){
        val sp = getSharedPreferences("session", Context.MODE_PRIVATE)
        sp.edit().apply{
            putString("username", username)
            commit()
        }
    }

    fun toCatalogo(){
        val intent = Intent(this, CatalogoActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStart() {
        super.onStart()

        val sp = getSharedPreferences("session", Context.MODE_PRIVATE)
        val tokenAcess = sp.getString("token", null)

        if(tokenAcess != null){
            toCatalogo()
        }
    }

}