package com.booksystem.booksystemapp.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.booksystem.booksystemapp.databinding.FormContatoLayoutBinding
import com.booksystem.booksystemapp.databinding.FormTarefaLayoutBinding
import com.booksystem.booksystemapp.model.Contato
import com.booksystem.booksystemapp.model.Tarefa
import com.booksystem.booksystemapp.repository.ContatoRepository
import com.booksystem.booksystemapp.repository.TarefaRepository
import com.google.android.material.snackbar.Snackbar

class FormularioContatoActivity : AppCompatActivity() {

    private lateinit var binding: FormContatoLayoutBinding
    private var contatoRep = ContatoRepository()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        binding = FormContatoLayoutBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        binding.btnVoltarContato.setOnClickListener { view ->
            val intent = Intent(this, ContatoActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnSalvarContato.setOnClickListener {view ->
            val edtNome = binding.edtNome.text
            val edtEmail = binding.edtEmail.text
            val edtTelefone = binding.edtTelefone.text
            val edtGrupo = binding.edtGrupo.text

            val contato = Contato("",
                edtNome.toString(),
                edtEmail.toString(),
                edtTelefone.toString(),
                edtGrupo.toString())

            contatoRep.salvarContato(contato,
                { response ->
                    if (response.code == 200) {
                        val snackbar =
                            Snackbar.make(view, "Contato adicionado", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.DKGRAY)
                        snackbar.show()
                        toContatos()
                    } else {
                        val snackbar = Snackbar.make(view,
                            "Não foi possível adicionar o contato. Tente novamente", Snackbar.LENGTH_SHORT)
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

    fun toContatos(){
        val intent = Intent(this, ContatoActivity::class.java)
        startActivity(intent)
        finish()
    }
}