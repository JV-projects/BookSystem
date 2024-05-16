package com.booksystem.booksystem.servico;

import java.util.List;
import java.util.Optional;

import com.booksystem.booksystem.model.Assunto;

public interface IAssuntoServico {
    public List<Assunto> consultarAssuntos();
    public Optional<Assunto> cadastrarAssunto(Assunto assunto);
    public void excluirAssunto(Long id);
}
