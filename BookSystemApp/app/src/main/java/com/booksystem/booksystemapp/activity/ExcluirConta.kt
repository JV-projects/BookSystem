package com.booksystem.booksystemapp.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.booksystem.booksystemapp.databinding.ExcluircontaLayoutBinding
import com.booksystem.booksystemapp.repository.CredenciaisRepository

class ExcluirConta : AppCompatActivity() {

    val credRep = CredenciaisRepository()
    private lateinit var binding: ExcluircontaLayoutBinding
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        binding = ExcluircontaLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnExcluir.setOnClickListener{
            val sp = getSharedPreferences("session", Context.MODE_PRIVATE)
            val username = sp.getString("username", "")

            credRep.deleteConta(username)
            sp.edit().clear().commit()

            toLogin()

        }


    }
    fun toLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}