package com.booksystem.booksystemapp.activity

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.booksystem.booksystemapp.R
import com.booksystem.booksystemapp.TarefaViewHolder
import com.booksystem.booksystemapp.model.Tarefa
import com.booksystem.booksystemapp.repository.TarefaRepository
import com.google.android.material.snackbar.Snackbar

class TarefaAdapter(private val dados: ArrayList<Tarefa>): RecyclerView.Adapter<TarefaViewHolder>() {

    private val repository = TarefaRepository()
    override fun onCreateViewHolder(viewGroup: ViewGroup, tipoView: Int): TarefaViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.tarefa_rcv, viewGroup, false)

        return TarefaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        holder.txtTarefa.text = dados[position].descricao
        holder.btnDeletar.setOnClickListener {view ->
            val tarefa = dados[position]
            repository.deletarTarefa(tarefa,
                {response ->
                if (response.code == 200) {
                    val snackbar = Snackbar.make(view, "Tarefa deletada", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.DKGRAY)
                    snackbar.show()
                    dados.remove(dados[position])
                }
            }, {exception ->
                    val snackbar = Snackbar.make(view,
                        "Erro: ${exception.localizedMessage}", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.DKGRAY)
                    snackbar.show()
                })
        }
    }

    override fun getItemCount(): Int {
        return dados.size
    }

}