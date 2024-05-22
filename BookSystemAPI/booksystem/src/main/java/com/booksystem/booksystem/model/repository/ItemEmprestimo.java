package com.booksystem.booksystem.model.repository;

import com.booksystem.booksystem.model.Livro;

public class ItemEmprestimo {
    private Livro livro;

    public ItemEmprestimo(){}

    public ItemEmprestimo(Livro livro) {
        this.livro = livro;
    }

    public Livro getLivro() {
        return this.livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
}
