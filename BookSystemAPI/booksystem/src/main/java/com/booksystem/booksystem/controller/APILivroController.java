package com.booksystem.booksystem.controller;

import org.springframework.web.bind.annotation.*;

import com.booksystem.booksystem.model.Livro;
import com.booksystem.booksystem.servico.interfaces.ILivroServico;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.springframework.http.ResponseEntity;

@CrossOrigin
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

    @GetMapping(value = "livros", params = {"titulo", "ordem"})
    public ResponseEntity<Object> consultaPorTitulo(@RequestParam String titulo, @RequestParam int ordem) {
        logger.info("api --> Consulta por Titulo");
        return ResponseEntity.ok().body(livroServico.consultarPorTitulo(titulo, ordem));
    }

    @PostMapping("livros")
    public ResponseEntity<Object> cadastrarLivro(@RequestBody Livro livro) {
        logger.info("api --> Cadastrar livro");

        return ResponseEntity.ok().body(livroServico.cadastrarLivro(livro));
    }


    

}
