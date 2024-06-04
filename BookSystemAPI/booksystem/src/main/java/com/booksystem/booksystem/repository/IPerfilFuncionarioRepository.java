package com.booksystem.booksystem.repository;

import com.booksystem.booksystem.model.PerfilFuncionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerfilFuncionarioRepository extends MongoRepository<PerfilFuncionario, String> {
}
