package com.booksystem.booksystemapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LivroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var txtTitulo: TextView
    var txtAutor: TextView
    var txtStatus: TextView

    init {
        txtTitulo = view.findViewById(R.id.txtTitulo)
        txtAutor = view.findViewById(R.id.txtAutor)
        txtStatus = view.findViewById(R.id.txtStatus)
    }
}