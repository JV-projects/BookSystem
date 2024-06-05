package com.booksystem.booksystem.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.booksystem.booksystem.model.Assunto;
import com.booksystem.booksystem.repository.IAssuntoRepository;

@Service
public class AssuntoServico implements IAssuntoServico{

    Logger logger = LogManager.getLogger(this.getClass());

    IAssuntoRepository assuntoRepository;

    public AssuntoServico(IAssuntoRepository assuntoRepository){
      this.assuntoRepository = assuntoRepository;
    }

    @Override
    public List<Assunto> consultarAssuntos() {
      logger.info("|--- Serviço - Consultando assunto ----|");
      return assuntoRepository.findAll();
    }

    @Override
    public Optional<Assunto> cadastrarAssunto(Assunto newAssunto) {
        logger.info("|--- Servico - Cadastrando assunto ----|");

        return Optional.ofNullable(assuntoRepository.insert(newAssunto));
    }

    @Override
    public void excluirAssunto(String id) {
        logger.info("|--- Servico - Excluindo assunto ----|");
        assuntoRepository.deleteById(id);
}
}