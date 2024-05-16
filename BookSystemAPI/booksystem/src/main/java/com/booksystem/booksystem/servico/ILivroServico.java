package com.booksystem.booksystem.servico;

import java.util.Optional;

import java.util.List;

import com.booksystem.booksystem.model.Livro;

public interface ILivroServico {
    public List<Livro> consultarLivros();
    public Optional<Livro> consultarPorTitulo(String titulo);
    public void excluirLivro(Long id);
}
