package com.booksystem.booksystem.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "imagens")
public class Imagem {

    @Id
    private String id;

    private byte[] arquivo; 

    Imagem(){}

    Imagem(byte[] arquivo){
        this.arquivo = arquivo;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getArquivo() {
        return this.arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

}
