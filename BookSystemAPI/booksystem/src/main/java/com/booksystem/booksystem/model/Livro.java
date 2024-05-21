package com.booksystem.booksystem.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;


@Document(collection = "livros")
public class Livro {

    @Id
    private String id;

    private String titulo;

    private String autor;

    private String editora;

    private int ano;

    private int edicao;

    private int paginas;

    private List<Assunto> assuntos = new ArrayList<>();

    private String etiqueta;

    private Long isbn;

    private String imagem;
    
    @Field(targetType = FieldType.STRING)
    private String status;

    public Livro(){}

    public Livro(String imagem){
        this.imagem = imagem;
    }

    public Livro(
        String titulo,
        String autor,
        String editora,
        int ano,
        int paginas,
        List<Assunto> assuntos,
        String etiqueta,
        Long isbn,
        String imagem,
        String status
    ){
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.paginas = paginas;
        this.assuntos = assuntos;
        this.etiqueta = etiqueta;
        this.isbn = isbn;
        this.imagem = imagem;
        this.status = status;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return this.editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getEdicao() {
        return this.edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getPaginas() {
        return this.paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public List<Assunto> getAssuntos() {
        return this.assuntos;
    }

    public void setAssuntos(List<Assunto> assuntos) {
        this.assuntos = assuntos;
    }

    public String getEtiqueta() {
        return this.etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Long getIsbn() {
        return this.isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getImagem(){
        return this.imagem;
    }

    public void setImagem(String imagem){
        this.imagem = imagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if(status != null){
            this.status = status.getStatus();
        }
    }

}
