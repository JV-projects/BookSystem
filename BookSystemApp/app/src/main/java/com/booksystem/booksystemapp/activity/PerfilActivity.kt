package com.booksystem.booksystemapp.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

import com.booksystem.booksystemapp.databinding.PerfilLayoutBinding
import com.booksystem.booksystemapp.repository.PerfilUsuarioRepository
import com.google.android.material.snackbar.Snackbar

class PerfilActivity : AppCompatActivity() {

    private lateinit var binding: PerfilLayoutBinding

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = PerfilLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEditar.setOnClickListener{
            val intent = Intent(this, EditarPerfilActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnExcluirConta.setOnClickListener{
            val intent = Intent(this, ExcluirConta::class.java)
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener{

            val sp = getSharedPreferences("session", Context.MODE_PRIVATE)
            sp.edit().clear().commit()
            toLogin()

        }


    }

    fun toLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()

        val perfilRep = PerfilUsuarioRepository()

        val sp = getSharedPreferences("session", Context.MODE_PRIVATE)
        val username = sp.getString("username", "")

        perfilRep.getPefil(username,
            {response, perfil ->

                if(!perfil.equals("")){

                    this@PerfilActivity.runOnUiThread{
                        binding.txtNome.setText(perfil.nome)
                        binding.txtEmail.setText(perfil.username)
                        binding.txtCpf.setText(perfil.cpf)
                        binding.txtTelefone.setText(perfil.cpf)
                        binding.txtCep.setText(perfil.cep)
                        binding.txtRua.setText(perfil.rua)
                        binding.txtNumero.setText(perfil.numero.toString())
                        binding.txtBairro.setText(perfil.bairro)
                        binding.txtCidade.setText(perfil.cidade)
                        binding.txtEstado.setText(perfil.estado)
                    }

                }

            }, {})

    }

}