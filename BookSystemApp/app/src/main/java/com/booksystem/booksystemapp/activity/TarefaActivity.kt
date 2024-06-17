package com.booksystem.booksystemapp.activity

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.booksystem.booksystemapp.databinding.TarefasLayoutBinding
import com.booksystem.booksystemapp.model.Tarefa
import com.booksystem.booksystemapp.repository.TarefaRepository
import com.google.android.material.snackbar.Snackbar

class TarefaActivity : AppCompatActivity() {

    private val repository = TarefaRepository()
    private val listaTarefas = ArrayList<Tarefa>()
    private lateinit var binding : TarefasLayoutBinding


    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        binding = TarefasLayoutBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        binding.rcvTarefas.layoutManager = LinearLayoutManager(this)
        val adapter = TarefaAdapter(listaTarefas)
        binding.rcvTarefas.adapter = adapter


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

        binding.btnAddTarefa.setOnClickListener { view ->
            val edtTarefa = binding.edtTarefa
            val tarefa = Tarefa(id = "", descricao = edtTarefa.text.toString())

            repository.salvarTarefa(tarefa, {response ->
                if (response.code == 200) {
                    val snackbar = Snackbar.make(view, "Tarefa adicionada", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.DKGRAY)
                    snackbar.show()
                    repository.carregarTarefas({ response, tarefas ->
                        this@TarefaActivity.runOnUiThread {
                            listaTarefas.clear()
                            listaTarefas.addAll(tarefas)
                            binding.rcvTarefas.adapter?.notifyDataSetChanged()
                        }
                    }, {})

                } else {
                    val snackbar = Snackbar.make(view,
                        "Não foi possível adicionar tarefa. Tente novamente", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.DKGRAY)
                    snackbar.show()
                }
            }, { exception ->
                val snackbar = Snackbar.make(view,
                    "Falha: ${exception.localizedMessage}", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.DKGRAY)
                snackbar.show()
            })
        }
    }
}