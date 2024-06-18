package com.booksystem.booksystemapp.activity

import android.content.Context
import android.content.Intent
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

        val sp = getSharedPreferences("session", Context.MODE_PRIVATE)

        val nome = binding.edtNome
        val username = binding.edtEmail
        username.setText(sp.getString("username", ""))
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
            toPerfil()
        }

    }

    fun toPerfil(){
        val intent = Intent(this, PerfilActivity::class.java)
        startActivity(intent)
        finish()
    }
    override fun onStart() {
        super.onStart()
        val sp = getSharedPreferences("session", Context.MODE_PRIVATE)

        perfil.getPefil(sp.getString("username", ""),
            { response, perfil ->
                if (!perfil.equals("")) {
                    this@EditarPerfilActivity.runOnUiThread {
                        binding.edtNome.setText(perfil.nome)
                        binding.edtEmail.setText(perfil.username)
                        binding.edtCPF.setText(perfil.cpf)
                        binding.edtTelefone.setText(perfil.cpf)
                        binding.edtCEP.setText(perfil.cep)
                        binding.edtRua.setText(perfil.rua)
                        binding.edtNumero.setText(perfil.numero.toString())
                        binding.edtBairro.setText(perfil.bairro)
                        binding.edtCidade.setText(perfil.cidade)
                        binding.edtEstado.setText(perfil.estado)
                    }
                }
            }, {})
    }

}