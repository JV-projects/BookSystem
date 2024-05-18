package com.booksystem.booksystem.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    private String autor;

    private String editora;

    private Date ano;

    private int edicao;

    private int paginas;

    private Assunto assunto;

    private String etiqueta;

    private Long isbn;

    
}
