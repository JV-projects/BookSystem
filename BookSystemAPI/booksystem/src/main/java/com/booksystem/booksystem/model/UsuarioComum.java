package com.booksystem.booksystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "usuario_comum")
public class UsuarioComum{

    @Id
    private String id;

    @DocumentReference(collection = "usuario")
    private Usuario usuario;

    private String cpf;

    public UsuarioComum(){}

    public UsuarioComum(String id, Usuario usuario, String cpf) {
        this.id = id;
        this.usuario = usuario;
        this.cpf = cpf;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
