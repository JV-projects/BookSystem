package com.booksystem.booksystem.repository;

import com.booksystem.booksystem.model.Emprestimo;
import com.booksystem.booksystem.model.PerfilUsuario;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmprestimoRepository extends MongoRepository<Emprestimo, String>{


    List<Emprestimo> findByUsuario(PerfilUsuario usuario);

    @Query(value = "{ 'usuario.nome': { $regex: ?0, $options:'i' } }")
    List<Emprestimo> findByNome(String nome, Sort sort);

    @Query(value = "{ 'usuario.username': { $regex: ?0, $options:'i' } }")
    List<Emprestimo> findByUsername(String username, Sort sort);


}
