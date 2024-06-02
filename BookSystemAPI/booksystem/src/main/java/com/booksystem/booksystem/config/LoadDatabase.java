package com.booksystem.booksystem.config;

import com.booksystem.booksystem.model.*;
import com.booksystem.booksystem.repository.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class LoadDatabase{

    @Bean
    CommandLineRunner initDataBase(IAssuntoRepository assuntoRepository, ILivroRepository livroRepository, ICredenciaisRepository credenciaisRepository,
                                   IPerfilUsuarioRepository perfilUsuarioRepository, IPerfilFuncionarioRepository perfilFuncionarioRepository, IEmprestimoRepository emprestimoRepository) {
        return args -> {

            assuntoRepository.deleteAll();
            livroRepository.deleteAll();
            credenciaisRepository.deleteAll();
            perfilUsuarioRepository.deleteAll();
            perfilFuncionarioRepository.deleteAll();
            emprestimoRepository.deleteAll();

            Imagem img = new Imagem();

            if (mongoTemplate.collectionExists(Livro.class)) {
                mongoTemplate.dropCollection(Livro.class);
            }
            if (mongoTemplate.collectionExists(Assunto.class)) {
                mongoTemplate.dropCollection(Assunto.class);
            }

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

            assuntoRepository.saveAll(lista);

            Livro livro1 = new Livro("O Código Da Vinci",
                    "Dan Brown",
                    "Editora X",
                    2003,
                    10,
                    454,
                    lista,
                    "1A2B",
                    9781234567890L,
                    "DISPONIVEL", img);

            Livro livro2 = new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling1", "Editora Z",
                    1997, 1, 332, lista, "3C4D", 9780747532743L, "DISPONIVEL", img);

            Livro livro3 = new Livro("Harry Potter e o Prisoneiro de Azkabam", "J.K. Rowling2", "Editora X",
                    1997, 1, 332, lista, "3C4D", 9780747532743L, "DISPONIVEL", img);

            Livro livro4 = new Livro("Harry Potter e o Enigma do Principe", "J.K. Rowling3", "Editora Y",
                    1997, 1, 332, lista, "3C4D", 9780747532743L, "DISPONIVEL", img);

            
                    Livro livro5 = new Livro("Harry Potter e a Ordem da Feníx", "J.K. Rowling4", "Editora W",
                    1998, 1, 332, lista, "3C4D", 9780747532743L, "DISPONIVEL", img);

            Livro livro6 = new Livro("Harry Potter e a Camara Secreta", "J.K. Rowling5", "Editora A",
                    1998, 1, 332, lista, "3C4D", 9780747532743L, "DISPONIVEL", img);

            Livro livro7 = new Livro("A Culpa é das Estrelas", "John Green", "Arqueiro",
                    2012, 2, 313, lista, "5E6F", 9780789483673L, "DISPONIVEL", img);

            Livro livro8 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "Machado",
                    1950, 3, 1178, lista, "7G8H", 9780544003415L, "INDISPONIVEL", img);

            Livro livro9 = new Livro("1984", "George Orwell", "Editora V",
                    1949, 4, 328, lista, "9I0J", 9780451524935L, "DISPONIVEL", img);

            Livro livro10 = new Livro("As Crônicas de Nárnia", "C.S. Lewis", "Lewis",
                    1950, 5, 767, lista, "1K2L", 9780066238500L, "DISPONIVEL", img);

                    Livro livro11 = new Livro("Dom Quixote", "Miguel de Cervantes", "XPTO",
                    1605, 6, 863, lista, "3M4N", 9780199537891L, "INDISPONIVEL", img);


            Livro livro12 = new Livro("Orgulho e Preconceito", "Jane Austen", "XYZ",
                    1813, 7, 329, lista, "5O6P", 9780141439518L, "DISPONIVEL", img);

            livroRepository.save(livro1);
            livroRepository.save(livro2);
            livroRepository.save(livro3);
            livroRepository.save(livro4);
            livroRepository.save(livro5);
            livroRepository.save(livro6);
            livroRepository.save(livro7);
            livroRepository.save(livro8);
            livroRepository.save(livro9);
            livroRepository.save(livro10);
            livroRepository.save(livro11);
            livroRepository.save(livro12);

            Credenciais u1 = new Credenciais("romeu@fatec", "ABC123", RoleUsuario.ADMIN);
            Credenciais u2 = new Credenciais("julieta@fatec", "ABC123", RoleUsuario.USER);

            List<Credenciais> list = new ArrayList<>();
            list.add(u1);
            list.add(u2);

            credenciaisRepository.insert(list);

            PerfilFuncionario pf = new PerfilFuncionario("Romeu", u1.getUsername(), u1);

            perfilFuncionarioRepository.insert(pf);

            List<String> telefones = new ArrayList<>();
            telefones.add("11988665533");
            telefones.add("1144556677");

            Optional<Credenciais> u3 = credenciaisRepository.findByUsername("julieta@fatec");

            PerfilUsuario pu = new PerfilUsuario("Julieta", "julieta@fatec", u3.get(), "24095367800", telefones,
                    "08565140", "Rua Book",55,  "System", "São Paulo", "São Paulo");

            perfilUsuarioRepository.insert(pu);

        };

    }
}
