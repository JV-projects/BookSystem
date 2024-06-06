package com.booksystem.booksystem.controller;

import com.booksystem.booksystem.model.Emprestimo;
import com.booksystem.booksystem.repository.IEmprestimoRepository;
import com.booksystem.booksystem.service.IEmprestimoServico;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
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

    @GetMapping(value = "emprestimos", params = {"nome", "filtro", "ordem"})
    public ResponseEntity<Object> consultarPorNome(@RequestParam String nome,
                                                   @RequestParam String filtro,
                                                   @RequestParam int ordem) {
        logger.info("api --> Consultar por nome");

        return ResponseEntity.ok().body(emprestimoServico.consultarPorNome(nome, filtro, ordem));
    }

    @GetMapping(value = "emprestimos", params = {"username", "filtro", "ordem"})
    public ResponseEntity<Object> consultarPorUsername(@RequestParam String username,
                                                       @RequestParam String filtro,
                                                       @RequestParam int ordem) {
        logger.info("api --> Consultar por username");

        return ResponseEntity.ok().body(emprestimoServico.consultarPorUsername(username, filtro, ordem));
    }

    @GetMapping("emprestimos/{id}")
    public ResponseEntity<Object> consultarEmprestimosUsuario(@PathVariable String id) {
        logger.info("api --> Consultar emprestimos do usuário");

        return ResponseEntity.ok().body(emprestimoServico.consultarEmprestimosUsuario(id));
    }

    @PatchMapping("emprestimos/{id}")
    public ResponseEntity<Object> atualizarEmprestimo(@PathVariable String id,
                                                      @RequestParam int operacao) {
        logger.info("api --> Renovar emprestimo");

        return ResponseEntity.ok().body(emprestimoServico.atualizarEmprestimo(id, operacao));
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
