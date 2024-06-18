package com.booksystem.booksystemapp

import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContatoViewHolder (view: View) : RecyclerView.ViewHolder(view)  {

    var txtNome : TextView
    var txtEmail : TextView
    var txtTelefone : TextView
    var txtGrupo : TextView
    var btnDel : ImageButton

    init {
        txtNome = view.findViewById(R.id.txt_nome_contato)
        txtEmail = view.findViewById(R.id.txt_email_contato)
        txtTelefone = view.findViewById(R.id.txt_email_contato)
        txtGrupo = view.findViewById(R.id.txt_grupo_contato)
        btnDel = view.findViewById(R.id.btnDeletarContato)
    }
}