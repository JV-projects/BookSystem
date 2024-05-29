package com.booksystem.booksystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.booksystem.booksystem.model.UsuarioComum;

@Repository
public interface IUsuarioComumRepository extends MongoRepository<UsuarioComum, String>{

}
