package com.booksystem.booksystem.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksystem.booksystem.model.ILivroRepository;
import com.booksystem.booksystem.model.Livro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class LivroServico implements ILivroServico{

    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    ILivroRepository livroRepository;

    @Override
    public List<Livro> consultarLivros() {
        logger.info("|--- Serviço - Consultando livros ----|");
        List<Livro> livros = livroRepository.findAll();

        return livros;
    }

    @Override
    public Optional<Livro> consultarPorTitulo(String titulo) {
       logger.info("|--- Serviço - Consultando por título ----|");
       Optional<Livro> livro = livroRepository.findByTitulo(titulo);
       
       return livro;
    }

    @Override
    public void excluirLivro(Long id) {
        logger.info("|--- Serviço - Excluindo livro ----|");
        livroRepository.deleteById(id);
    }

}
