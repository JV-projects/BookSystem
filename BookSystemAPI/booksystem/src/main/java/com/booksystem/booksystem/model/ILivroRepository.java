package com.booksystem.booksystem.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ILivroRepository extends JpaRepository<Livro, Long>{
    Optional<Livro> findByTitulo(String titulo);
}
