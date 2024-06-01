package com.booksystem.booksystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
public class Usuario {

    @Id
    private String id;

    private String nome;

    // Um username é tudo o que vem antes de '@gmail.com' - '@fatec.sp.gov.br' em um email
    @Indexed
    private String username;

    private String senha;

    private RoleUsuario role;


    public Usuario(String id, String nome, String username, String senha, RoleUsuario role) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.role = role;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public RoleUsuario getRole() {
        return this.role;
    }

    public void setRole(RoleUsuario role) {
        this.role = role;
    }
    

}
