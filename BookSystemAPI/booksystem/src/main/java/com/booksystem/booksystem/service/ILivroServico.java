package com.booksystem.booksystem.service;

import java.util.Optional;

import java.util.List;

import com.booksystem.booksystem.model.Livro;
import com.booksystem.booksystem.model.TagDTO;

import java.util.List;
import java.util.Optional;

public interface ILivroServico {

    List<Livro> consultarLivros();

    Optional<Livro> cadastrarLivro(Livro livro);

    Optional<Livro> consultarPorId(String id);

    List<Livro> consultarPorTitulo(String titulo, int ano, String filtro, int ordem);

    List<Livro> consultarPorTituloMobile(String titulo);

    List<Livro> consultarPorIsbn(long isbn);

    List<Livro> consultarPorAutor(String autor, int ano, String filtro, int ordem);

    List<Livro> consultarPorEditora(String editora, int ano, String filtro, int ordem);

    Optional<Livro> editarLivro(Livro livro);

    void excluirLivro(String id);

    List<TagDTO> consultarTags();



}
