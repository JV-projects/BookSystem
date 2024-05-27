package com.booksystem.booksystem.servico.interfaces;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import com.booksystem.booksystem.model.Livro;

public interface ILivroServico {
    
    public List<Livro> consultarLivros();
    public List<Livro> consultarPorIsbn(long isbn);
    public Optional<Livro> cadastrarLivro(Livro livro);
    public Optional<Livro> editarLivro(Livro livro);
    public void excluirLivro(String id);

}
