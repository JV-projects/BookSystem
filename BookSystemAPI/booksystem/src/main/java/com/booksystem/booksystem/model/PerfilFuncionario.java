package com.booksystem.booksystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document("perfil_funcionario")
public class PerfilFuncionario {

    @Id
    private String id;
    private String nome;
    private String email;

    @DocumentReference(collection = "credenciais_usuario")
    private Credenciais credenciais;

    public PerfilFuncionario(String nome, String email, Credenciais credenciais) {
        this.nome = nome;
        this.email = email;
        this.credenciais = credenciais;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Credenciais getCredenciais() {
        return credenciais;
    }

    public void setCredenciais(Credenciais credenciais) {
        this.credenciais = credenciais;
    }
}
