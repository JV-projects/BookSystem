package com.booksystem.booksystem.servico.interfaces;

import com.booksystem.booksystem.model.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IPesquisaServico<T> {
     List<T> OrdemPesquisa(MongoRepository<T, String> repository, int ordem);
}
