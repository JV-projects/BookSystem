package com.booksystem.booksystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;

import com.booksystem.booksystem.model.Livro;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.booksystem.booksystem.servico.LivroServico;
import com.booksystem.booksystem.model.repository.ILivroRepository;

@SpringBootTest
class BooksystemApplicationTests {
	@Autowired
	private ILivroRepository livroRepository;

	@Test
	void testAssunto() {
		LivroServico servico = new LivroServico(livroRepository);

		assert(!servico.consultarLivros().isEmpty())
	}

}
