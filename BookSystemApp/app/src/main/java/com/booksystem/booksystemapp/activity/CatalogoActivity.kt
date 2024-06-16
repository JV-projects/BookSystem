package com.booksystem.booksystemapp.activity

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booksystem.booksystemapp.LivroAdapter
import com.booksystem.booksystemapp.R
import com.booksystem.booksystemapp.databinding.CatalogoLayoutBinding
import com.booksystem.booksystemapp.model.Livro
import com.booksystem.booksystemapp.repository.LivroRepository

class CatalogoActivity : AppCompatActivity() {
    private val repository = LivroRepository()
    private val dados = ArrayList<Livro>()
    private lateinit var binding: CatalogoLayoutBinding

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = CatalogoLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcvLivros.layoutManager = LinearLayoutManager(this)
        val adapter = LivroAdapter(dados)
        binding.rcvLivros.adapter = adapter


    }

    override fun onStart() {
        super.onStart()

        val edtPesquisa = findViewById<EditText>(R.id.edtPesquisar)
        val btnPesquisar = findViewById<ImageButton>(R.id.btnPesquisar)

        btnPesquisar.setOnClickListener {
            val textoPesquisa = binding.edtPesquisar.text.toString()
            repository.findAllByTitulo(textoPesquisa, "a",
                { _, livros ->
                    this@CatalogoActivity.runOnUiThread {
                        dados.clear()
                        dados.addAll(livros)
                        binding.rcvLivros.adapter?.notifyDataSetChanged()
                    }
                }, {})
        }

    }
}