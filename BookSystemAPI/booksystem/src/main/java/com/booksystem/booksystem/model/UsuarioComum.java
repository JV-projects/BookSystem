package com.booksystem.booksystem.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario_comum")
public class UsuarioComum extends Usuario{

    private String cpf;
    
    private List<String> telefones;

    private int cep;

    private int numero;

    private String rua;

    private String bairro;

    private String cidade;

    private String estado;
    
    public UsuarioComum(String id, String nome, String username, String senha, RoleUsuario role,
                        String cpf, List<String> telefones, int cep, int numero, String rua, String bairro, String cidade, String estado) {
        
                            super(id, nome, username, senha, role);
        this.cpf = cpf;
        this.telefones = telefones;
        this.cep = cep;
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }


    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<String> getTelefones() {
        return this.telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    public int getCep() {
        return this.cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


   
}
