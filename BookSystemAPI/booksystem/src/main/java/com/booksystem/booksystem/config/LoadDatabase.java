package com.booksystem.booksystem.config;

import com.booksystem.booksystem.model.Imagem;
import com.booksystem.booksystem.model.Livro;
import com.booksystem.booksystem.model.RoleUsuario;
import com.booksystem.booksystem.model.Usuario;
import com.booksystem.booksystem.model.UsuarioComum;
import com.booksystem.booksystem.repository.IAssuntoRepository;
import com.booksystem.booksystem.repository.ILivroRepository;
import com.booksystem.booksystem.repository.IUsuarioComumRepository;
import com.booksystem.booksystem.repository.IUsuarioRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.booksystem.booksystem.model.Assunto;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadDatabase{

    @Bean
    CommandLineRunner initDataBase(IAssuntoRepository assuntoRepository, ILivroRepository livroRepository, IUsuarioRepository usuarioRepository,
    IUsuarioComumRepository usuarioComumRepository) {
        return args -> {

            assuntoRepository.deleteAll();
            livroRepository.deleteAll();
            usuarioRepository.deleteAll();
            usuarioComumRepository.deleteAll();


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

            Usuario usuario = new Usuario("Romeu", "romjulieta@gmail.com", "ABC123", RoleUsuario.USER);
            Usuario usuario2 = new Usuario("Julieta", "jujulieta@gmail.com", "ABC123", RoleUsuario.USER);

            List<Usuario> usuarios = new ArrayList<>();
            usuarios.add(usuario);
            usuarios.add(usuario2);

            UsuarioComum usuarioComum = new UsuarioComum(usuario.getId(), usuario, "12345678900");

            usuarioRepository.saveAll(usuarios);
            usuarioComumRepository.save(usuarioComum);


        };

    }
}
