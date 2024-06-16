package com.booksystem.booksystemapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.booksystem.booksystemapp.model.Livro
import com.booksystem.booksystemapp.LivroViewHolder

class LivroAdapter(private val dados: ArrayList<Livro>) :
    RecyclerView.Adapter<LivroViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): LivroViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.livro_rcv, viewGroup, false)

        return LivroViewHolder(view)
    }

    override fun onBindViewHolder(holder: LivroViewHolder, posicao: Int) {
        holder.txtTitulo.text = dados[posicao].titulo
        holder.txtAutor.text = dados[posicao].autor
        holder.txtStatus.text = dados[posicao].status
    }

    override fun getItemCount(): Int {
        return dados.size
    }
}