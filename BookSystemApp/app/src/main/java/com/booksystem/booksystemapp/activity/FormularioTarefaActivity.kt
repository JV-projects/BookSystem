package com.booksystem.booksystemapp.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.booksystem.booksystemapp.R
import com.booksystem.booksystemapp.databinding.FormTarefaLayoutBinding
import com.booksystem.booksystemapp.model.Tarefa
import com.booksystem.booksystemapp.repository.TarefaRepository
import com.google.android.material.snackbar.Snackbar

class FormularioTarefaActivity : AppCompatActivity() {

    private lateinit var binding: FormTarefaLayoutBinding
    private var repository = TarefaRepository()
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        binding = FormTarefaLayoutBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        binding.btnVoltarTarefa.setOnClickListener { view ->
            val intent = Intent(this, TarefaActivity::class.java)
            startActivity(intent)
        }

        binding.btnSalvarTarefa.setOnClickListener {view ->
            val edtDescricao = binding.edtDescricao.text
            val spinnerPrioridade = binding.spinnerPrioridade.selectedItem
            val edtMarcador = binding.edtMarcador.text

            val tarefa = Tarefa(id = "",
                descricao = edtDescricao.toString(),
                spinnerPrioridade.toString(),
                edtMarcador.toString())

            repository.salvarTarefa(tarefa,
                { response ->
                    if (response.code == 200) {
                        val snackbar =
                            Snackbar.make(view, "Tarefa adicionada", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.DKGRAY)
                        snackbar.show()
                    } else {
                        val snackbar = Snackbar.make(view,
                            "Não foi possível adicionar tarefa. Tente novamente", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.DKGRAY)
                        snackbar.show()
                    }
                },
                {exception ->
                        val snackbar = Snackbar.make(view,
                            "Falha: ${exception.localizedMessage}", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.DKGRAY)
                        snackbar.show()
                    })

        }

    }
}