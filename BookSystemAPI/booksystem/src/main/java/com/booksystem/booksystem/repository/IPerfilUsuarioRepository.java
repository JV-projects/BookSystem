package com.booksystem.booksystem.repository;

import com.booksystem.booksystem.model.PerfilUsuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPerfilUsuarioRepository extends MongoRepository<PerfilUsuario, String>{

    Optional<PerfilUsuario> findByCpf(String cpf);

    Optional<PerfilUsuario> findByUsername(String username);

    void deleteByUsername(String username);
}
