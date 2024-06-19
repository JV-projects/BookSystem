package com.booksystem.booksystemapp

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GastoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var txtGasto: TextView
    var txtNaureza: TextView
    var txtData: TextView
    var btnDel: ImageButton

    init {
        txtGasto = view.findViewById(R.id.txtGasto)
        txtNaureza = view.findViewById(R.id.txtNatureza)
        txtData = view.findViewById(R.id.txtData)
        btnDel = view.findViewById(R.id.btnDeletarGasto)
    }
}