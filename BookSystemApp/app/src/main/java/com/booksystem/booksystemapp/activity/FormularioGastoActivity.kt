package com.booksystem.booksystemapp.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.booksystem.booksystemapp.databinding.FormularioGastoLayoutBinding
import com.booksystem.booksystemapp.model.Gasto
import com.booksystem.booksystemapp.repository.GastoRepository
import com.google.android.material.snackbar.Snackbar

class FormularioGastoActivity : AppCompatActivity() {
    private val gastoRep = GastoRepository()
    private lateinit var binding: FormularioGastoLayoutBinding

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = FormularioGastoLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSalvarGasto.setOnClickListener { view ->
            val edtGasto = binding.edtGasto.text
            val edtNatureza = binding.edtNatureza.text
            val edtData = binding.edtData.text

            val gasto = Gasto(
                "",
                edtGasto.toString().toDouble(),
                edtNatureza.toString(),
                edtData.toString()
            )

            gastoRep.salvarGasto(gasto,
                { response ->
                    if (response.code == 200) {
                        val snackbar =
                            Snackbar.make(view, "Gasto adicionado", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.DKGRAY)
                        snackbar.show()
                        toGastos()
                    } else {
                        val snackbar = Snackbar.make(
                            view,
                            "Não foi possível adicionar. Tente novamente", Snackbar.LENGTH_SHORT
                        )
                        snackbar.setBackgroundTint(Color.DKGRAY)
                        snackbar.show()
                    }
                },
                { exception ->
                    val snackbar = Snackbar.make(
                        view,
                        "Falha: ${exception.localizedMessage}", Snackbar.LENGTH_SHORT
                    )
                    snackbar.setBackgroundTint(Color.DKGRAY)
                    snackbar.show()
                })

        }


    }

    fun toGastos() {
        val intent = Intent(this, GastoActivity::class.java)
        startActivity(intent)
        finish()
    }
}