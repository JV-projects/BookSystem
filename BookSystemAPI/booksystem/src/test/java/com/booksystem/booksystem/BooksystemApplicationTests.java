package com.booksystem.booksystem;

import com.booksystem.booksystem.model.Assunto;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.booksystem.booksystem.service.AssuntoServico;
import com.booksystem.booksystem.repository.IAssuntoRepository;

import java.util.List;

@SpringBootTest
class BooksystemApplicationTests {

	@Autowired
	private IAssuntoRepository assuntoRepository;

	@Test
	void testeCadastroAssunto() {


		AssuntoServico as = new AssuntoServico(assuntoRepository);

		Assunto assunto = new Assunto("Romance");

		as.cadastrarAssunto(assunto);

	}

	@Test
	void testeConsultaAssunto() {

		AssuntoServico assuntoServico = new AssuntoServico(assuntoRepository);

		List<Assunto> lista = assuntoServico.consultarAssuntos();

		assert(!lista.isEmpty());
	}

}
