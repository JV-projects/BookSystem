package com.booksystem.booksystem.servico;

import com.booksystem.booksystem.model.Imagem;
import com.booksystem.booksystem.model.Livro;
import com.booksystem.booksystem.model.repository.ILivroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.booksystem.booksystem.model.Assunto;
import com.booksystem.booksystem.model.repository.IAssuntoRepository;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadDatabase{

    @Bean
    CommandLineRunner initDataBase(IAssuntoRepository assuntoRepository, ILivroRepository livroRepository) {
        return args -> {
            List<Assunto> lista = new ArrayList<>();

            Assunto literaturaEstrangeira = new Assunto("Literatura estrangeira");
            Assunto romance = new Assunto("Romance");
            Assunto programacao = new Assunto("Programacao");

            lista.add(literaturaEstrangeira);
            lista.add(romance);

            assuntoRepository.saveAll(lista);

            Imagem img = new Imagem();

            // salvar infos de texto uppercase ou lowercase, senão tem que usar colation e index case insensitive

            Livro livro1 = new Livro("Orgulho e Preconceito", "Jane Austen", "Martin Claret",
                    2012, 444, lista, "A7F9K10F", 9788544001820L, "DISPONIVEL", img);

            lista.clear();
            lista.add(programacao);

            Livro livro2 = new Livro("Java®: Como Programar", "Paul Deitel", "Pearson Universidades",
                    2016, 333, lista, "G5H7J9M1", 9788543004792L, "DISPONIVEL", img);


            livroRepository.save(livro1);
            livroRepository.save(livro2);
        };

    }
}
