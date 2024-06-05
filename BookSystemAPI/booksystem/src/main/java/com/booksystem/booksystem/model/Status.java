package com.booksystem.booksystem.model;


public enum Status {

    DISPONIVEL("Disponível", "0"),
    INDISPONIVEL("Indisponível", "1"),
    CONCLUIDO("Concluído", "2"),
    ANDAMENTO("Em andamento", "3"),
    ATRASO("Em atraso", "4");

    private final String status;
    private final String codigo;

    Status(String status, String codigo) {
        this.status = status;
        this.codigo = codigo;
    }

    public String getStatus() {
        return status;
    }

    public String getCodigo(){
        return codigo;
    }

}
