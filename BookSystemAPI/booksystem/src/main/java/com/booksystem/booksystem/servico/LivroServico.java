package com.booksystem.booksystem.servico;

import com.booksystem.booksystem.model.Livro;
import com.booksystem.booksystem.model.repository.ILivroRepository;
import com.booksystem.booksystem.servico.interfaces.ILivroServico;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServico implements ILivroServico {

    Logger logger = LogManager.getLogger(this.getClass());

    ILivroRepository livroRepository;

    PesquisaServico pesquisaServico;

    public LivroServico(ILivroRepository livroRepository, PesquisaServico pesquisaServico) {
        this.livroRepository = livroRepository;
        this.pesquisaServico = pesquisaServico;
    }

    @Override
    public List<Livro> consultarLivros() {
        logger.info("|--- Serviço - Consultando livros ----|");
        return livroRepository.findAll();
    }

    @Override
    public List<Livro> consultarPorTitulo(String titulo, int ano, String filtro, int ordem) {
        logger.info("|--- Serviço - Consultando por título --- |");

        Sort sort = pesquisaServico.sortBuilder(titulo, filtro, ordem);

        if (ano != 0) {
            return livroRepository.findByTitulo(titulo, ano, sort);
        } else {
            return livroRepository.findByTitulo(titulo, sort);
        }
    }

    @Override
    public List<Livro> consultarPorIsbn(long isbn) {
        logger.info("|--- Serviço - Consultando por ISBN ---|");

        return livroRepository.findByIsbn(isbn);
    }

    @Override
    public List<Livro> consultarPorAutor(String autor, int ano, String filtro, int ordem) {
        logger.info("|--- Serviço - Consultando por autor ---|");

        Sort sort = pesquisaServico.sortBuilder(autor, filtro, ordem);

        if (ano != 0) {
            return livroRepository.findByAutor(autor, ano, sort);
        } else {
            return livroRepository.findByAutor(autor, sort);
        }
    }

    @Override
    public List<Livro> consultarPorEditora(String editora, int ano, String filtro, int ordem) {
        logger.info("|--- Serviço - Consultando por editora");

        Sort sort = pesquisaServico.sortBuilder(editora, filtro, ordem);

        if (ano != 0) {
            return livroRepository.findByEditora(editora, ano, sort);
        } else {
            return livroRepository.findByEditora(editora, sort);
        }
    }

    @Override
    public void excluirLivro(String id) {
        logger.info("|--- Serviço - Excluindo livro ----|");
        livroRepository.deleteById(id);
    }

    @Override
    public Optional<Livro> cadastrarLivro(Livro newLivro) {

        logger.info("|---- Serviço - Cadastrando livro ----|");
        return Optional.of(livroRepository.insert(newLivro));
    }


}
