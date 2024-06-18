package com.booksystem.booksystemapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.booksystem.booksystemapp.ContatoAdapter
import com.booksystem.booksystemapp.databinding.ContatoLayoutBinding
import com.booksystem.booksystemapp.model.Contato
import com.booksystem.booksystemapp.repository.ContatoRepository

class ContatoActivity : AppCompatActivity() {

    private val contatoRep = ContatoRepository()
    private val listaContato = ArrayList<Contato>()
    private lateinit var binding: ContatoLayoutBinding

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        binding = ContatoLayoutBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        binding.rcvContatos.layoutManager = LinearLayoutManager(this)
        val adapter = ContatoAdapter(listaContato)
        binding.rcvContatos.adapter = adapter

        binding.btnCriarContato.setOnClickListener {
            val intent = Intent(this, FormularioContatoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()

        contatoRep.carregarContatos({ response, contatos ->
            this@ContatoActivity.runOnUiThread {
                listaContato.clear()
                listaContato.addAll(contatos)
                binding.rcvContatos.adapter?.notifyDataSetChanged()
            }
        }, {})
    }

}