package com.booksystem.booksystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booksystem.booksystem.model.Livro;
import com.booksystem.booksystem.servico.interfaces.ILivroServico;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.springframework.http.ResponseEntity;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("booksystem/api")
public class APILivroController {
    Logger logger = LogManager.getLogger(this.getClass());

    private ILivroServico livroServico;

    public APILivroController(ILivroServico livroServico){
        this.livroServico = livroServico;
    }

    @GetMapping("livros")
    public ResponseEntity<Object> consultarLivros(){
        logger.info("api --> Consultar livro");
        return ResponseEntity.ok().body(livroServico.consultarLivros());
    }

    @GetMapping("livro")
    public ResponseEntity<Object> consultarPorId(@RequestBody String id){
        logger.info("api --> Consultar livro por ID");
        return ResponseEntity.ok().body(livroServico.consultarPorId(id));
    }

    // @GetMapping("livro")
    // public ResponseEntity<Object> consultarPorIsbn(@RequestBody long isbn){
    //     logger.info("api --> Consultar livro por ISBN");
    //     return ResponseEntity.ok().body(livroServico.consultarPorIsbn(isbn));
    // }

    @PostMapping("livros")
    public ResponseEntity<Object> cadastrarLivro(@RequestBody Livro livro) {
        logger.info("api --> Cadastrar livro");

        return ResponseEntity.ok().body(livroServico.cadastrarLivro(livro));
    }

    @PatchMapping("livros")
    public ResponseEntity<Object> editarLivro(@RequestBody Livro livro){
        logger.info("api --> Editar livro");

        return ResponseEntity.ok().body(livroServico.editarLivro(livro));
    }
    
    @DeleteMapping("livros")
    public ResponseEntity<Object> excluirLivro(@RequestBody String id){
        logger.info("api --> Excluir livro");
        
        livroServico.excluirLivro(id);

        return ResponseEntity.ok().body("Ok");
    }

}
