package com.booksystem.booksystem.service;

import org.springframework.data.domain.Sort;

public interface IPesquisaServico {
    Sort.Direction retornarOrdem(int ordem);

    <T> Sort sortBuilder(T pesquisa, String filtro, int ordem);

}
