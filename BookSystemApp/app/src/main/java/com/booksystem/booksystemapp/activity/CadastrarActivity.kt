package com.booksystem.booksystemapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.booksystem.booksystemapp.databinding.CadastrarLayoutBinding
import com.booksystem.booksystemapp.model.Credenciais
import com.booksystem.booksystemapp.model.PerfilUsuario
import com.booksystem.booksystemapp.repository.CredenciaisRepository

class CadastrarActivity : AppCompatActivity() {

    private val credRep = CredenciaisRepository()
    private lateinit var binding : CadastrarLayoutBinding
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        binding = CadastrarLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = binding.edtEmail
        val senha = binding.edtSenha

        binding.btnCadastrar.setOnClickListener{
            val c = Credenciais(username.text.toString(), senha.text.toString());
            credRep.newCredenciais(c)
        }


    }
}