package com.booksystem.booksystem.servico.interfaces;

import org.springframework.data.domain.Sort;

public interface IPesquisaServico {
    Sort.Direction retornarOrdem(int ordem);

    <T> Sort sortBuilder(T pesquisa, String filtro, int ordem);

}
