package com.booksystem.booksystemapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.booksystem.booksystemapp.model.Gasto
import com.booksystem.booksystemapp.repository.GastoRepository
import com.google.android.material.snackbar.Snackbar

class GastoAdapter(private val dados: ArrayList<Gasto>) :
    RecyclerView.Adapter<GastoViewHolder>() {

    private val gastoRep = GastoRepository()
    override fun onCreateViewHolder(viewGroup: ViewGroup, tipoView: Int): GastoViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.gasto_rcv, viewGroup, false)

        return GastoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dados.size
    }

    override fun onBindViewHolder(holder: GastoViewHolder, posicao: Int) {

        holder.txtGasto.text = dados[posicao].gasto.toString()
        holder.txtNaureza.text = dados[posicao].natureza
        holder.txtData.text = dados[posicao].data

        holder.btnDel.setOnClickListener { view ->
            val gasto = dados[posicao]
            gastoRep.deletarGasto(gasto,
                { response ->
                    if (response.code == 200) {
                        val snackbar = Snackbar.make(view, "Gasto deletado", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.DKGRAY)
                        snackbar.show()

                        dados.remove(dados[posicao])
                        notifyDataSetChanged()

                    }
                }, { exception ->
                    val snackbar = Snackbar.make(
                        view,
                        "Erro: ${exception.localizedMessage}", Snackbar.LENGTH_SHORT
                    )
                    snackbar.setBackgroundTint(Color.DKGRAY)
                    snackbar.show()
                })
        }
    }


}