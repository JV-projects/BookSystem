package com.booksystem.booksystem.service;

import com.booksystem.booksystem.model.Imagem;
import com.booksystem.booksystem.repository.IImagemRepository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ImagemServico implements IImagemServico {

    Logger logger = LogManager.getLogger(this.getClass());

    private IImagemRepository imagemRepository;

    public ImagemServico(IImagemRepository imagemRepository) {
        this.imagemRepository = imagemRepository;
    }

    @Override
    public String verificarTamanhoImagem(String imagemByte) {

        if(imagemByte == null){
            return null;
        }

        logger.info("|---- Serviço - Verificando imagem ----|");

        if (imagemByte.getBytes().length <= 34000) {
            return imagemByte;
        } else {
            throw new IllegalArgumentException("Arquivo maior que 34kb");
        }
    }

    @Override
    public List<Imagem> getImagem() {
        logger.info("|---- Serviço - Consultando imagens ----|");
        return imagemRepository.findAll();
    }


}
