package com.booksystem.booksystem.model.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booksystem.booksystem.model.Livro;

public interface ILivroRepository extends MongoRepository<Livro, String>{
    Optional<Livro> findByTitulo(String titulo);
}
