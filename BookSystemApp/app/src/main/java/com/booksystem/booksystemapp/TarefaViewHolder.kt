package com.booksystem.booksystemapp

import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TarefaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var checkTarefa: CheckBox
    var txtDescricao: TextView
    var txtPrioridade: TextView
    var txtMarcador: TextView
    var btnDeletar: ImageButton

    init {
        checkTarefa = view.findViewById(R.id.checkTarefa)
        txtDescricao = view.findViewById(R.id.txtDescricao)
        txtPrioridade = view.findViewById(R.id.txtPrioridade)
        txtMarcador = view.findViewById(R.id.txtMarcador)
        btnDeletar = view.findViewById(R.id.btnDeletar)
    }
}