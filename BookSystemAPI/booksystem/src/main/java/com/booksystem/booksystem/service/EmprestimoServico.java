package com.booksystem.booksystem.service;

import java.util.List;
import java.util.Optional;

import com.booksystem.booksystem.model.PerfilUsuario;
import com.booksystem.booksystem.model.Status;
import com.booksystem.booksystem.repository.IPerfilUsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.booksystem.booksystem.model.Emprestimo;
import com.booksystem.booksystem.repository.IEmprestimoRepository;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoServico implements IEmprestimoServico{

    Logger logger = LogManager.getLogger(this.getClass());

    private IEmprestimoRepository emprestimoRepository;
    private IPerfilUsuarioRepository perfilUsuarioRepository;

    public EmprestimoServico(IEmprestimoRepository emprestimoRepository, IPerfilUsuarioRepository perfilUsuarioRepository){
        this.emprestimoRepository = emprestimoRepository;
        this.perfilUsuarioRepository = perfilUsuarioRepository;
    }

    @Override
    public List<Emprestimo> consultarEmprestimos() {
       logger.info("|---- Serviço - Consultando empréstimo ----|");
       return emprestimoRepository.findAll();
    }

    @Override
    public Optional<Emprestimo> cadastrarEmprestimo(String username, Emprestimo emprestimo) {
       logger.info("|---- Serviço - Cadastrando empréstimo ----|");

       Optional<PerfilUsuario> usuario = perfilUsuarioRepository.findByUsername(username);

       emprestimo.setUsuario(usuario.get());
       emprestimo.setStatus(Status.ANDAMENTO);

       return Optional.ofNullable(emprestimoRepository.insert(emprestimo));
    }

}
