package com.booksystem.booksystemapp

import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TarefaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var checkTarefa: CheckBox
    var txtTarefa: TextView
    var btnDeletar: ImageButton

    init {
        checkTarefa = view.findViewById(R.id.checkTarefa)
        txtTarefa = view.findViewById(R.id.txtTarefa)
        btnDeletar = view.findViewById(R.id.btnDeletar)
    }
}