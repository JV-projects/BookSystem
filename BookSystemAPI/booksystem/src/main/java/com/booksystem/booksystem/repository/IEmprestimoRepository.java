package com.booksystem.booksystem.repository;

import com.booksystem.booksystem.model.Emprestimo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmprestimoRepository extends MongoRepository<Emprestimo, String>{
}
