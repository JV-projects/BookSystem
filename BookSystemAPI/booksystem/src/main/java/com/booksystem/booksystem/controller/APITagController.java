package com.booksystem.booksystem.controller;

import com.booksystem.booksystem.service.LivroServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("booksystem/api")
@Tag(name = "API TAGs", description = "Enpoints destinados a integração com IOT.")
public class APITagController {
    Logger logger = LogManager.getLogger(this.getClass());

    private final LivroServico livroServico;

    public APITagController(LivroServico livroServico) {
        this.livroServico = livroServico;
    }

    @GetMapping("tags")
    @Operation(summary = "Consultar TAGs", description = "Recupera TAGs RFID do livros")
    public ResponseEntity<Object> consultarTags() {
        logger.info("api --> Consultando as tags");

        return ResponseEntity.ok().body(livroServico.consultarTags());
    }

}
