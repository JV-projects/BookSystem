package com.booksystem.booksystemapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.booksystem.booksystemapp.GastoAdapter
import com.booksystem.booksystemapp.databinding.PlanilhaGastoLayoutBinding
import com.booksystem.booksystemapp.model.Gasto
import com.booksystem.booksystemapp.repository.GastoRepository

class GastoActivity : AppCompatActivity() {


    private val gastoRep = GastoRepository()
    private val listaGasto = ArrayList<Gasto>()
    private lateinit var binding: PlanilhaGastoLayoutBinding

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = PlanilhaGastoLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcvGastos.layoutManager = LinearLayoutManager(this)
        val adapter = GastoAdapter(listaGasto)
        binding.rcvGastos.adapter = adapter

        binding.btnNovoGasto.setOnClickListener {
            val intent = Intent(this, FormularioGastoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        gastoRep.carregarGastos({ response, gastos ->
            this@GastoActivity.runOnUiThread {
                listaGasto.clear()
                listaGasto.addAll(gastos)

                var totalGasto: Double = 0.0

                listaGasto.forEach({ g ->
                    totalGasto += g.gasto
                })
                binding.txtTotal.setText("$" + totalGasto.toString())

                binding.rcvGastos.adapter?.notifyDataSetChanged()
            }
        }, {})
    }
}