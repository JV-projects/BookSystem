package com.booksystem.booksystem.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.booksystem.booksystem.model.Livro;

@Repository
public interface ILivroRepository extends MongoRepository<Livro, String>{
    public List<Livro> findByIsbn(long isbn);
}
