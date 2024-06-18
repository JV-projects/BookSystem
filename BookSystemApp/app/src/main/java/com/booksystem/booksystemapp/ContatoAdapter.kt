package com.booksystem.booksystemapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.booksystem.booksystemapp.model.Contato
import com.booksystem.booksystemapp.repository.ContatoRepository
import com.google.android.material.snackbar.Snackbar


class ContatoAdapter(private val dados: ArrayList<Contato>): RecyclerView.Adapter<ContatoViewHolder>() {

    private val contatoRep = ContatoRepository()
    override fun onCreateViewHolder(viewGroup: ViewGroup, tipoView: Int): ContatoViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.contato_rcv, viewGroup, false)

        return ContatoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        holder.txtNome.text = dados[position].nome
        holder.txtEmail.text = dados[position].email
        holder.txtTelefone.text = dados[position].telefone
        holder.txtGrupo.text = dados[position].grupo

        holder.btnDel.setOnClickListener {view ->
            val contato = dados[position]
            contatoRep.deletarContato(contato,
                {response ->
                    if (response.code == 200) {
                        val snackbar = Snackbar.make(view, "Contato deletado", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.DKGRAY)
                        snackbar.show()
                        dados.remove(dados[position])
                        notifyDataSetChanged()
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