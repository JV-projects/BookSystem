package com.booksystem.booksystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "emprestimos")
public class Emprestimo {

    @Id
    private String id;

    private List<Livro> itensEmprestimo = new ArrayList<>();

    private LocalDate dataRetirada;

    private LocalDate dataDevolucao;

    private String status;

    @DocumentReference(collection = "perfil_usuario")
    private PerfilUsuario usuario;

    public Emprestimo() {
    }

    public Emprestimo(List<Livro> itensEmprestimo, LocalDate dataRetirada, LocalDate dataDevolucao, String status, PerfilUsuario usuario) {
        this.itensEmprestimo = itensEmprestimo;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Livro> getItensEmprestimo() {
        return itensEmprestimo;
    }

    public void setItensEmprestimo(List<Livro> itensEmprestimo) {
        this.itensEmprestimo = itensEmprestimo;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public PerfilUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(PerfilUsuario usuario) {
        this.usuario = usuario;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatus(Status status) {
        if (status != null) {
            this.status = status.getStatus();
        }
    }


}
