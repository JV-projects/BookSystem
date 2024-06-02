package com.booksystem.booksystem.config;

import com.booksystem.booksystem.model.*;
import com.booksystem.booksystem.repository.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
