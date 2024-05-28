package com.booksystem.booksystem.servico;

import com.booksystem.booksystem.model.Livro;
import com.booksystem.booksystem.servico.interfaces.IPesquisaServico;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public class PesquisaServico<T> implements IPesquisaServico<T> {
    @Override
    public List<T> OrdemPesquisa(MongoRepository<T, String> repository, int ordem) {

    }
}
