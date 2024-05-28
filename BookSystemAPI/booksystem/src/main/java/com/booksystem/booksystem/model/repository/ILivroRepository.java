package com.booksystem.booksystem.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booksystem.booksystem.model.Livro;
import org.springframework.data.mongodb.repository.Query;

public interface ILivroRepository extends MongoRepository<Livro, String>{

    @Query(value = "{ 'titulo': { $regex: ?0, $options:'i' } }", sort = "{ titulo: 1 }")
    List<Livro> findByTituloAsc(String titulo);

    @Query(value = "{ 'titulo': { $regex: ?0, $options:'i' } }", sort = "{ titulo: -1 }")
    List<Livro> findByTituloDesc(String titulo);

}
