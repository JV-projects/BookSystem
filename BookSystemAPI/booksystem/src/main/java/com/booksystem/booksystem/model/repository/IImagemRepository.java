package com.booksystem.booksystem.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booksystem.booksystem.model.Imagem;

public interface IImagemRepository extends MongoRepository<Imagem, String>{
}
