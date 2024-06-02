package com.booksystem.booksystem.repository;

import com.booksystem.booksystem.model.Livro;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ILivroRepository extends MongoRepository<Livro, String> {

    @Query(value = "{ 'titulo': { $regex: ?0, $options:'i' }, ano: ?1 }")
    List<Livro> findByTitulo(String titulo, int ano, Sort sort);

    @Query(value = "{ 'titulo': { $regex: ?0, $options:'i' } }")
    List<Livro> findByTitulo(String titulo, Sort sort);

    List<Livro> findByIsbn(long isbn);

    @Query(value = "{ 'autor': { $regex: ?0, $options:'i' }, ano: ?1 }")
    List<Livro> findByAutor(String autor, int ano, Sort sort);

    @Query(value = "{ 'autor': { $regex: ?0, $options:'i' } }")
    List<Livro> findByAutor(String autor, Sort sort);

    @Query(value = "{ 'editora': { $regex: ?0, $options:'i' }, ano: ?1}")
    List<Livro> findByEditora(String editora, int ano, Sort sort);

    @Query(value = "{ 'editora': { $regex: ?0, $options:'i' } }")
    List<Livro> findByEditora(String editora, Sort sort);

}
