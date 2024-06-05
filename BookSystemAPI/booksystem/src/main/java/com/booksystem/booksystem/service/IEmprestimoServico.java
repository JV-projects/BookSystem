package com.booksystem.booksystem.service;

import java.util.List;
import java.util.Optional;

import com.booksystem.booksystem.model.Emprestimo;
import org.springframework.data.domain.Sort;

public interface IEmprestimoServico {

    public List<Emprestimo> consultarEmprestimos();

    public List<Emprestimo> consultarPorNome(String nome, String filtro, int ordem);

    public List<Emprestimo> consultarPorUsername(String username, String filtro, int ordem);

    public List<Emprestimo> consultarEmprestimosUsuario(String id);

    public Optional<Emprestimo> atualizarEmprestimo(String id, int operacao);

    public Optional<Emprestimo> cadastrarEmprestimo(String username, Emprestimo emprestimo);


}
