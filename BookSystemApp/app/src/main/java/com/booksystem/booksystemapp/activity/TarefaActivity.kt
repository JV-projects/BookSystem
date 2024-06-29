package com.booksystem.booksystemapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.booksystem.booksystemapp.TarefaAdapter
import com.booksystem.booksystemapp.databinding.TarefasLayoutBinding
import com.booksystem.booksystemapp.model.Tarefa
import com.booksystem.booksystemapp.repository.TarefaRepository

class TarefaActivity : AppCompatActivity() {

    private val repository = TarefaRepository()
    private val listaTarefas = ArrayList<Tarefa>()
    private lateinit var binding: TarefasLayoutBinding


    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        binding = TarefasLayoutBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        binding.rcvTarefas.layoutManager = LinearLayoutManager(this)
        val adapter = TarefaAdapter(listaTarefas)
        binding.rcvTarefas.adapter = adapter

        binding.btnCriarTarefa.setOnClickListener {
            val intent = Intent(this, FormularioTarefaActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onStart() {
        super.onStart()

        repository.carregarTarefas({ response, tarefas ->
            this@TarefaActivity.runOnUiThread {
                listaTarefas.clear()
                listaTarefas.addAll(tarefas)
                binding.rcvTarefas.adapter?.notifyDataSetChanged()
            }
        }, {})
    }
}