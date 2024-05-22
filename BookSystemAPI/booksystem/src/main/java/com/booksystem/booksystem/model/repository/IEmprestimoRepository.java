package com.booksystem.booksystem.model.repository;

import com.booksystem.booksystem.model.Emprestimo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IEmprestimoRepository extends MongoRepository<Emprestimo, String>{
}
