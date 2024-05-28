package com.booksystem.booksystem.servico;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.booksystem.booksystem.model.Emprestimo;
import com.booksystem.booksystem.model.repository.IEmprestimoRepository;
import com.booksystem.booksystem.servico.interfaces.IEmprestimoServico;

public class EmprestimoServico implements IEmprestimoServico{

    Logger logger = LogManager.getLogger(this.getClass());

    private IEmprestimoRepository emprestimoRepository;

    public EmprestimoServico(IEmprestimoRepository emprestimoRepository){
        this.emprestimoRepository = emprestimoRepository;
    }

    @Override
    public List<Emprestimo> consultarEmprestimos() {
       logger.info("|---- Serviço - Consultando empréstimo ----|");
       return emprestimoRepository.findAll();
    }

    @Override
    public Optional<Emprestimo> cadastrarEmprestimo(Emprestimo emprestimo) {
       logger.info("|---- Serviço - Cadastrando empréstimo ----|");

       return Optional.ofNullable(emprestimoRepository.insert(emprestimo));
    }

    @Override
    public Optional<Emprestimo> renovarEmprestimo(Emprestimo emprestimo) {
        logger.info("|---- Serviço - Renovando empréstimo ----|");

       return emprestimoRepository.findById(emprestimo.getId())
                .map(emp -> {
                    emp.setDataDevolucao(emprestimo.getDataDevolucao());
                    return emprestimoRepository.save(emprestimo);
                });
    }

}
