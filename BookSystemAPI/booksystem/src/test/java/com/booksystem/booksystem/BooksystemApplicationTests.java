package com.booksystem.booksystem;

import com.booksystem.booksystem.model.Assunto;
import com.booksystem.booksystem.repository.IAssuntoRepository;
import com.booksystem.booksystem.service.AssuntoServico;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BooksystemApplicationTests {

	@Autowired
	private IAssuntoRepository assuntoRepository;

	@Test
	void testeConsultaAssunto() {

		AssuntoServico assuntoServico = new AssuntoServico(assuntoRepository);

		List<Assunto> lista = assuntoServico.consultarAssuntos();

		assert(!lista.isEmpty());
	}

}
