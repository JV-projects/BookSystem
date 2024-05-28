package com.booksystem.booksystem.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booksystem.booksystem.model.Livro;
import org.springframework.data.mongodb.repository.Query;

public interface ILivroRepository extends MongoRepository<Livro, String>{

    @Query(value = "{ 'titulo': { $regex: ?0, $options:'i' } }")
    List<Livro> findByTitulo(String titulo, int ordem);
}
