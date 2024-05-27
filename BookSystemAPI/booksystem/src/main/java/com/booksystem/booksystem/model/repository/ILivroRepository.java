package com.booksystem.booksystem.model.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.booksystem.booksystem.model.Livro;

public interface ILivroRepository extends MongoRepository<Livro, String>{
    List<Livro> findByIsbn(long isbn);
}
