package com.booksystem.booksystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.booksystem.booksystem.model.Usuario;

@Repository
public interface IUsuarioRepository extends MongoRepository<Usuario, String>{
}
