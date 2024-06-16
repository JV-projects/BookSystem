package com.booksystem.booksystemapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.booksystem.booksystemapp.databinding.EditarperfilLayoutBinding
import com.booksystem.booksystemapp.model.PerfilUsuario
import com.booksystem.booksystemapp.repository.PerfilUsuarioRepository


class EditarPerfilActivity : AppCompatActivity(){

    private val perfil = PerfilUsuarioRepository()
    private lateinit var binding: EditarperfilLayoutBinding
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        binding = EditarperfilLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nome = binding.edtNome
        val username = binding.edtEmail
        val cpf = binding.edtCPF
        val telefone = binding.edtTelefone
        val cep = binding.edtCEP
        val rua = binding.edtRua
        val numero = binding.edtNumero
        val bairro = binding.edtBairro
        val cidade = binding.edtCidade
        val estado = binding.edtEstado

        binding.btnSalvar.setOnClickListener{
            val pu = PerfilUsuario(nome.text.toString(),
                                username.text.toString(),
                                cpf.text.toString(),
                                telefone.text.toString(),
                                cep.text.toString(),
                                rua.text.toString(),
                                numero.text.toString().toInt(),
                                bairro.text.toString(),
                                cidade.text.toString(),
                                estado.text.toString());

            perfil.savePerfil(pu)

        }

    }

}