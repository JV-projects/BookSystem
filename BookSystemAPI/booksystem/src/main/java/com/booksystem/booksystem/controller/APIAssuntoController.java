package com.booksystem.booksystem.controller;

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
public class APIAssuntoController {

    Logger logger = LogManager.getLogger(this.getClass());

    private IAssuntoServico assuntoServico;

    public APIAssuntoController(IAssuntoServico assuntoServico){
        this.assuntoServico = assuntoServico;
    }


    @GetMapping("assuntos")
    public ResponseEntity<Object> consultarAssuntos(){
        logger.info("api --> Consultar assunto");
        return ResponseEntity.status(HttpStatus.OK).body(assuntoServico.consultarAssuntos());
    }


}
