package com.booksystem.booksystem.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booksystem.booksystem.model.Assunto;

import java.util.List;


public interface IAssuntoRepository extends MongoRepository<Assunto, String>{
    List<Assunto> findByNome(String nome);
}   
