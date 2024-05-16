package com.booksystem.booksystem.servico;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksystem.booksystem.model.Assunto;
import com.booksystem.booksystem.model.IAssuntoRepository;

public class AssuntoServico implements IAssuntoServico{

    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    IAssuntoRepository assuntoRepository;

    @Override
    public List<Assunto> consultarAssuntos() {
      logger.info("|--- Serviço - Consultando assunto ----|");
      List<Assunto> assuntos = assuntoRepository.findAll();

      return assuntos;
    }

    @Override
    public Optional<Assunto> cadastrarAssunto(Assunto newAssunto) {
        logger.info("|--- Servico - Cadastrando assunto ----|");

        return Optional.ofNullable(assuntoRepository.save(newAssunto));
    }

    @Override
    public void excluirAssunto(Long id) {
        logger.info("|--- Servico - Excluindo assunto ----|");
        assuntoRepository.deleteById(id);
}
}