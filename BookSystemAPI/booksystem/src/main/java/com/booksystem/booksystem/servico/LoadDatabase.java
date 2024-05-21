package com.booksystem.booksystem.servico;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.booksystem.booksystem.model.Assunto;
import com.booksystem.booksystem.model.repository.IAssuntoRepository;

@Configuration
public class LoadDatabase{

    @Bean
    CommandLineRunner initDataBase(IAssuntoRepository assuntoRepository){
        return args -> {

            Assunto assunto = new Assunto("Literatura estrangeira");

            assuntoRepository.save(assunto);


        };
    }


}
