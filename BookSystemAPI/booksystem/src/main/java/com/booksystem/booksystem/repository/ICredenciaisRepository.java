package com.booksystem.booksystem.repository;

import com.booksystem.booksystem.model.Credenciais;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICredenciaisRepository extends MongoRepository<Credenciais, String> {
    @Query(value="{username:'?0'}", fields="{'senha' : 0, 'role' : 0}")
    Optional<Credenciais> findByUsername(String s);
}
