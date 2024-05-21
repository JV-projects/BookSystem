package com.booksystem.booksystem.servico.interfaces;

import java.util.Optional;
import java.util.List;

import com.booksystem.booksystem.model.Imagem;

public interface IImagemServico {

    public String verificarTamanhoImagem(String imagemByte);
    public Optional<Imagem> uploadImagem(String idImagem, String imagemByte);
    public List<Imagem> getImagem();

}
