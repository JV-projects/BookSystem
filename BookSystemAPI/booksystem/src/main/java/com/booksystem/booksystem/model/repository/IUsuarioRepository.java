package com.booksystem.booksystem.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booksystem.booksystem.model.Usuario;

public interface IUsuarioRepository extends MongoRepository<Usuario, String>{
}
