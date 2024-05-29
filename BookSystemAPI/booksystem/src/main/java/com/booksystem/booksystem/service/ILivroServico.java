package com.booksystem.booksystem.service;

import java.util.Optional;

import java.util.List;

import com.booksystem.booksystem.model.Livro;

public interface ILivroServico {
    
    public List<Livro> consultarLivros();
    public Optional<Livro> consultarPorId(String id);
    public List<Livro> consultarPorIsbn(long isbn);
    public Optional<Livro> cadastrarLivro(Livro livro);
    public Optional<Livro> editarLivro(Livro livro);
    public void excluirLivro(String id);

}
