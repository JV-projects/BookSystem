package com.booksystem.booksystem.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.booksystem.booksystem.model.Livro;

@Repository
public interface ILivroRepository extends MongoRepository<Livro, String>{
    public List<Livro> findByIsbn(long isbn);
}
