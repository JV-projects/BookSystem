package com.booksystem.booksystem.servico;

import com.booksystem.booksystem.servico.interfaces.IPesquisaServico;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PesquisaServico implements IPesquisaServico {

    @Override
    public Sort.Direction retornarOrdem(int ordem) {
        if (ordem == -1) {
            return Sort.Direction.DESC;
        } else {
            return Sort.Direction.ASC;
        }
    }

    @Override
    public <T> Sort sortBuilder(T pesquisa, String filtro, int ordem) {
        Sort.Direction direction = retornarOrdem(ordem);
        Sort.Order order = new Sort.Order(direction, filtro);
        return Sort.by(order);
    }
}
