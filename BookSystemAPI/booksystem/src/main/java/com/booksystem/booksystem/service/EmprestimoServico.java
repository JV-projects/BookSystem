package com.booksystem.booksystem.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.booksystem.booksystem.model.PerfilUsuario;
import com.booksystem.booksystem.model.Status;
import com.booksystem.booksystem.repository.IPerfilUsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.booksystem.booksystem.model.Emprestimo;
import com.booksystem.booksystem.repository.IEmprestimoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoServico implements IEmprestimoServico{

    Logger logger = LogManager.getLogger(this.getClass());

    private IEmprestimoRepository emprestimoRepository;
    private IPerfilUsuarioRepository perfilUsuarioRepository;
    PesquisaServico pesquisaServico;

    public EmprestimoServico(IEmprestimoRepository emprestimoRepository,
                             IPerfilUsuarioRepository perfilUsuarioRepository,
                             PesquisaServico pesquisaServico){

        this.emprestimoRepository = emprestimoRepository;
        this.perfilUsuarioRepository = perfilUsuarioRepository;
        this.pesquisaServico = pesquisaServico;
    }

    @Override
    public List<Emprestimo> consultarEmprestimos() {
       logger.info("|---- Serviço - Consultando empréstimo ----|");
       return emprestimoRepository.findAll();
    }

    @Override
    public List<Emprestimo> consultarPorNome(String nome, String filtro, int ordem) {
        logger.info("|---- Serviço - Consultando por nome de usuário ----|");

        Sort sort = pesquisaServico.sortBuilder(nome, filtro, ordem);
        return emprestimoRepository.findByNome(nome, sort);
    }

    @Override
    public List<Emprestimo> consultarPorUsername(String username, String filtro, int ordem) {
        logger.info("|---- Serviço - Consultando por username ----|");

        Sort sort = pesquisaServico.sortBuilder(username, filtro, ordem);
        return emprestimoRepository.findByUsername(username, sort);
    }

    @Override
    public List<Emprestimo> consultarEmprestimosUsuario(String id) {
        logger.info("|---- Serviço - Consultando emprestimos do usuário ----|");

        Optional<PerfilUsuario> usuario = perfilUsuarioRepository.findById(id);

        return emprestimoRepository.findByUsuario(usuario.get());
    }

    @Override
    public Optional<Emprestimo> atualizarEmprestimo(String id, int operacao) {
        logger.info("|---- Serviço - Atualizando empréstimo ----|");

        Emprestimo emprestimo = emprestimoRepository.findById(id).get();
        if (operacao == 0) {
            logger.info("|---- Operação 0 - Encerrando empréstimo ----|");
            emprestimo.setDataDevolucao(LocalDate.now());
            emprestimo.setStatus(Status.CONCLUIDO);
            return Optional.of(emprestimoRepository.save(emprestimo));
        } else if (operacao == 1) {
            logger.info("|---- Operação 1 - Renovando empréstimo ----|");
            emprestimo.setDataDevolucao(emprestimo.getDataDevolucao().plusDays(7));
            return Optional.of(emprestimoRepository.save(emprestimo));
        }

        return Optional.empty();
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
