package com.booksystem.booksystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.booksystem.booksystem.model.Imagem;
import com.booksystem.booksystem.model.Livro;
import com.booksystem.booksystem.model.Status;
import com.booksystem.booksystem.repository.ILivroRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class LivroServico implements ILivroServico {

    Logger logger = LogManager.getLogger(this.getClass());

    ILivroRepository livroRepository;

    ImagemServico imagemServico;

    public LivroServico(ILivroRepository livroRepository, ImagemServico imagemServico) {
        this.livroRepository = livroRepository;
        this.imagemServico = imagemServico;
    }

    @Override
    public List<Livro> consultarLivros() {
        logger.info("|--- Serviço - Consultando livros ----|");
        return livroRepository.findAll();
    }

    @Override
    public Optional<Livro> consultarPorId(String id){
        logger.info("|--- Serviço - Consultando livro por id ----|");
        Optional<Livro> livro = livroRepository.findById(id);

        return livro;
    }

    @Override
    public List<Livro> consultarPorIsbn(long isbn) {
        logger.info("|--- Serviço - Consultando por ISBN ----|");
        return livroRepository.findByIsbn(isbn);
    }

    @Override
    public Optional<Livro> cadastrarLivro(Livro newLivro) {
        logger.info("|---- Serviço - Cadastrando livro ----|");
        newLivro.setStatus(Status.DISPONIVEL);

        Imagem imagem = newLivro.getImagem();

        if (imagem != null && imagem.getArquivoBase() != null) {
            
            imagemServico.verificarTamanhoImagem(imagem.getArquivoBase());

        }

        return Optional.ofNullable(livroRepository.insert(newLivro));
    }

    @Override
    public Optional<Livro> editarLivro(Livro newLivro) {
       logger.info("|---- Serviço - Editando livro ----|");

       return livroRepository.findById(newLivro.getId())
            .map(livro -> {
                livro.setTitulo(newLivro.getTitulo());
                livro.setAutor(newLivro.getAutor());
                livro.setEditora(newLivro.getEditora());
                livro.setAno(newLivro.getAno());
                livro.setPaginas(newLivro.getPaginas());
                livro.setAssuntos(newLivro.getAssuntos());
                livro.setEtiqueta(newLivro.getEtiqueta());
                livro.setIsbn(newLivro.getIsbn());
                livro.setImagem(newLivro.getImagem());
                return livroRepository.save(livro);
            });
    }

    @Override
    public void excluirLivro(String id) {
        logger.info("|--- Serviço - Excluindo livro ----|");
        
        try{
            livroRepository.deleteById(id);
        }catch(Exception e){
            logger.info("Não excluiu");
        }
        
    }

}
