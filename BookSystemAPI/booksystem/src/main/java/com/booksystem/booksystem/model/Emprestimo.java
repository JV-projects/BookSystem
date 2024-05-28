package com.booksystem.booksystem.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "emprestimos")
public class Emprestimo {
    @Id
    private String id;

    private List<Livro> itensEmprestimo = new ArrayList<>();

    private Date dataRetirada;
    
    private Date dataDevolucao;

    private String status;

    private String idUsuario;

    public Emprestimo(){}

    public Emprestimo(String id, List<Livro> itensEmprestimo, Date dataRetirada, Date dataDevolucao, String status, String idUsuario) {
        this.id = id;
        this.itensEmprestimo = itensEmprestimo;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.idUsuario = idUsuario;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Livro> getItensEmprestimo() {
        return this.itensEmprestimo;
    }

    public void setItensEmprestimo(List<Livro> itensEmprestimo) {
        this.itensEmprestimo = itensEmprestimo;
    }

    public Date getDataRetirada() {
        return this.dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataDevolucao() {
        return this.dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        if(status != null){
            this.status = status.getStatus();
        }
    }

    public String getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
