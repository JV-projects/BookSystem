package com.booksystem.booksystem.servico;

import java.util.ArrayList;
import java.util.List;

import com.booksystem.booksystem.model.repository.ILivroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.booksystem.booksystem.model.Assunto;
import com.booksystem.booksystem.model.Livro;
import com.booksystem.booksystem.model.repository.IAssuntoRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;

@Configuration
public class LoadDatabase{

    

    @Bean
    CommandLineRunner initDataBase(IAssuntoRepository assuntoRepository, ILivroRepository livroRepository, MongoTemplate mongoTemplate){
        return args -> {

            TextIndexDefinition stringIndex = new TextIndexDefinition.TextIndexDefinitionBuilder()
                    .withDefaultLanguage("portuguese")
                    .named("string_index")
                    .onFields("livro.titulo", "livro.autor", "livro.editora", "livro.assuntos")
                    .build();

            mongoTemplate.indexOps(Livro.class).ensureIndex(stringIndex);

            List<Assunto> lista = new ArrayList<>();


            Assunto literaturaEstrangeira = new Assunto("Literatura estrangeira");
            Assunto romance = new Assunto("Romance");
            Assunto programacao = new Assunto("Programacao");

            lista.add(literaturaEstrangeira);
            lista.add(romance);


            assuntoRepository.saveAll(lista );

            // salvar infos de texto uppercase ou lowercase, senão tem que usar colation e index case insensitive

            Livro livro1 = new Livro("ORGULHO E PRECONCEITO", "JANE AUSTEN", "MARTIN CLARET",
                    2012, 444, lista, "A7F9K10F",9788544001820L , "DISPONIVEL");

            lista.clear();
            lista.add(programacao);

            Livro livro2 = new Livro("JAVA®: COMO PROGRAMAR", "PAUL DEITEL", "PEARSON UNIVERSIDADES",
                    2016, 333, lista, "G5H7J9M1",9788543004792L, "DISPONIVEL");


            livroRepository.save(livro1);
            livroRepository.save(livro2);
        };
    }


}
