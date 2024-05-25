package com.booksystem.booksystem.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booksystem.booksystem.model.UsuarioComum;

public interface IUsuarioComumRepository extends MongoRepository<UsuarioComum, String>{

}
