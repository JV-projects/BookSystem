package com.booksystem.booksystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.booksystem.booksystem.model.Assunto;

import java.util.List;

@Repository
public interface IAssuntoRepository extends MongoRepository<Assunto, String>{
    List<Assunto> findByNome(String nome);
}   
