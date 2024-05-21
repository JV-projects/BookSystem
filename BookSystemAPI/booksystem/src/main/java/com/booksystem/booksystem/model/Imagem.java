package com.booksystem.booksystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "imagens")
public class Imagem {

    @Id
    private String id;

    private String arquivoByte; 

    public Imagem(){}

    public Imagem(String id, String arquivoByte){
        this.id = id;
        this.arquivoByte = arquivoByte;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArquivoByte() {
        return this.arquivoByte;
    }

    public void setArquivoByte(String arquivoByte) {
        this.arquivoByte = arquivoByte;
    }

}
