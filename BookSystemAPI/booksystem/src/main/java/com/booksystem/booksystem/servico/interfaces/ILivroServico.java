package com.booksystem.booksystem.servico.interfaces;

import java.util.Optional;

import java.util.List;

import com.booksystem.booksystem.model.Livro;

public interface ILivroServico {
    
    public List<Livro> consultarLivros();
    public Optional<Livro> cadastrarLivro(Livro livro);
    public List<Livro> consultarPorIsbn(Long isbn);
    public void excluirLivro(String id);

}
