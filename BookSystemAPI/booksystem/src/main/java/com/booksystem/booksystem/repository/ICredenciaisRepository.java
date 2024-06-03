package com.booksystem.booksystem.repository;

import com.booksystem.booksystem.model.Credenciais;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICredenciaisRepository extends MongoRepository<Credenciais, String> {

    Optional<Credenciais> findByUsername(String s);
}
