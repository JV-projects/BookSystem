package com.booksystem.booksystem.controller;

import com.booksystem.booksystem.model.Emprestimo;
import com.booksystem.booksystem.service.IEmprestimoServico;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("booksystem/api")
public class APIEmprestimoController {

    Logger logger = LogManager.getLogger(this.getClass());

    private IEmprestimoServico emprestimoServico;

    public APIEmprestimoController(IEmprestimoServico emprestimoServico) {
        this.emprestimoServico = emprestimoServico;
    }

    @GetMapping("emprestimos")
    public ResponseEntity<Object> consultarEmprestimos(){
        logger.info("api --> Consultar empréstimo");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(emprestimoServico.consultarEmprestimos());
    }

    @PostMapping( value = "emprestimos", params = "username")
    public ResponseEntity<Object> cadastrarEmprestimo(@RequestBody Emprestimo emprestimo,
                                                      @RequestParam String username){

        logger.info("api --> Cadastrar empréstimo");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(emprestimoServico.cadastrarEmprestimo(username, emprestimo));
    }
}
