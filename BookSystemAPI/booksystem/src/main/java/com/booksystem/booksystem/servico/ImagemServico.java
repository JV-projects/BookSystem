package com.booksystem.booksystem.servico;

import com.booksystem.booksystem.model.Imagem;
import com.booksystem.booksystem.model.repository.IImagemRepository;
import com.booksystem.booksystem.servico.interfaces.IImagemServico;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ImagemServico implements IImagemServico {

    Logger logger = LogManager.getLogger(this.getClass());

    private IImagemRepository imagemRepository;

    public ImagemServico(IImagemRepository imagemRepository) {
        this.imagemRepository = imagemRepository;
    }

    @Override
    public String verificarTamanhoImagem(String imagemByte) {

        logger.info("|---- Serviço - Verificando tamanho da imagem ----|");

        if (imagemByte.getBytes().length <= 34000) {
            return imagemByte;
        } else {
            throw new IllegalArgumentException("Arquivo maior que 34kb");
        }
    }

    @Override
    public Optional<Imagem> uploadImagem(String idImagem, String imagemByte) {
        logger.info("|---- Serviço - Cadastrando imagem do livro ----|");

        Imagem imagem = new Imagem(idImagem, imagemByte);

        return Optional.ofNullable(imagemRepository.insert(imagem));
    }

    @Override
    public List<Imagem> getImagem() {
        logger.info("|---- Serviço - Consultando imagens ----|");
        return imagemRepository.findAll();
    }


}
