package com.booksystem.booksystem.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booksystem.booksystem.model.Assunto;
import com.booksystem.booksystem.service.IAssuntoServico;

@RestController
@RequestMapping("booksystem/api")
@Tag(name = "API Assunto", description = "Endpoints de assuntos.")
public class APIAssuntoController {

    Logger logger = LogManager.getLogger(this.getClass());

    private IAssuntoServico assuntoServico;

    public APIAssuntoController(IAssuntoServico assuntoServico){
        this.assuntoServico = assuntoServico;
    }


    @GetMapping("assuntos")
    @Operation(description = "Consulta todos os assuntos de livros cadastrados")
    public ResponseEntity<Object> consultarAssuntos(){
        logger.info("api --> Consultar assunto");
        return ResponseEntity.status(HttpStatus.OK).body(assuntoServico.consultarAssuntos());
    }

}
