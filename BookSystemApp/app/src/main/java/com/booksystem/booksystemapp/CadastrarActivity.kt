package com.booksystem.booksystemapp

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booksystem.booksystemapp.model.Livro
import com.booksystem.booksystemapp.repository.LivroRepository

class CadastrarActivity : AppCompatActivity() {

    private val repository = LivroRepository()
    private val dados = ArrayList<Livro>()
    private lateinit var rcvLivro: RecyclerView

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.catalogo_layout)

        rcvLivro = findViewById(R.id.rcvLivros)
        rcvLivro.layoutManager = LinearLayoutManager(this)
        val adapter = LivroAdapter(dados)
        rcvLivro.adapter = adapter


    }

    override fun onStart() {
        super.onStart()

        val edtPesquisa = findViewById<EditText>(R.id.edtPesquisar)
        val btnPesquisar = findViewById<ImageButton>(R.id.btnPesquisar)

        btnPesquisar.setOnClickListener {
            val textoPesquisa = edtPesquisa.text.toString()
            repository.findAllByTitulo(textoPesquisa, "a",
                { _, livros ->
                    this@CadastrarActivity.runOnUiThread {
                        dados.clear()
                        dados.addAll(livros)
                        rcvLivro.adapter?.notifyDataSetChanged()
                    }
                }, {})
        }

    }
}