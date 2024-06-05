package com.booksystem.booksystem.service;

import java.util.List;

import com.booksystem.booksystem.model.Imagem;

public interface IImagemServico {

    public String verificarTamanhoImagem(String imagemByte);
    public List<Imagem> getImagem();

}
