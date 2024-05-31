package com.booksystem.booksystem.servico.interfaces;

import com.booksystem.booksystem.model.Livro;

import java.util.List;
import java.util.Optional;

public interface ILivroServico {

    List<Livro> consultarLivros();

    Optional<Livro> cadastrarLivro(Livro livro);

    List<Livro> consultarPorTitulo(String titulo, int ano, String filtro, int ordem);

    List<Livro> consultarPorIsbn(long isbn);

    List<Livro> consultarPorAutor(String autor, int ano, String filtro, int ordem);

    List<Livro> consultarPorEditora(String editora, int ano, String filtro, int ordem);

    void excluirLivro(String id);
}
