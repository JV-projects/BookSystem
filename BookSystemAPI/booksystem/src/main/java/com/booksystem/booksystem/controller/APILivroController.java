package com.booksystem.booksystem.controller;

import com.booksystem.booksystem.model.Livro;
import com.booksystem.booksystem.service.ILivroServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("booksystem/api")
@Tag(name = "API Livro", description = "Enpoints para controle de livros.")
public class APILivroController {
    Logger logger = LogManager.getLogger(this.getClass());

    private ILivroServico livroServico;

    public APILivroController(ILivroServico livroServico) {
        this.livroServico = livroServico;
    }

    @GetMapping("livros")
    @Operation(summary = "Consultar livro", description = "Consulta todos os livros do sistema.")
    public ResponseEntity<Object> consultarLivros() {
        logger.info("api --> Consultar livro");
        return ResponseEntity.ok().body(livroServico.consultarLivros());
    }

    @GetMapping(value = "livros", params = {"titulo", "filtro", "ordem"})
    @Operation(summary = "Consultar livro com filtro")
    public ResponseEntity<Object> consultaPorTitulo(@RequestParam String titulo,
                                                    @RequestParam(required = false, defaultValue = "0") int ano,
                                                    @RequestParam(required = false) String filtro,
                                                    @RequestParam int ordem) {

        logger.info("api --> Consulta por Titulo");
        return ResponseEntity.ok().body(livroServico.consultarPorTitulo(titulo, ano, filtro, ordem));
    }

    @GetMapping(value = "livros", params = "titulo")
    @Operation(summary = "Consultar livro (mobile)", description = "Consulta todos os livros do sistema.")
    public ResponseEntity<Object> consultaLivrosMobile(@RequestParam String titulo) {
        logger.info("api --> Consulta livros mobile");
        return ResponseEntity.ok().body(livroServico.consultarPorTituloMobile(titulo));
    }

    @GetMapping(value = "livros", params = "isbn")
    @Operation(summary = "Consultar livro por ISBN", description = "Consulta um livro pelo seu ISBN.")
    public ResponseEntity<Object> consultarPorIsbn(@RequestParam long isbn) {
        logger.info("api --> Consulta por ISBN");
        return ResponseEntity.ok(livroServico.consultarPorIsbn(isbn));
    }

    @GetMapping(value = "livros", params = {"autor", "filtro", "ordem"})
    @Operation(summary = "Consultar livro por autor", description = "Consulta todos os livros de um determinado autor.")
    public ResponseEntity<Object> consultaPorAutor(@RequestParam String autor,
                                                   @RequestParam(required = false, defaultValue = "0") int ano,
                                                   @RequestParam(required = false) String filtro,
                                                   @RequestParam int ordem) {
        logger.info("api --> Consulta por autor");
        return ResponseEntity.ok().body(livroServico.consultarPorAutor(autor, ano, filtro, ordem));
    }

    @GetMapping(value = "livros", params = {"editora", "filtro", "ordem"})
    @Operation(summary = "Consultar livro por editora", description = "Consulta todos os livros de uma determinada editora.")
    public ResponseEntity<Object> consultarPorEditora(@RequestParam String editora,
                                                      @RequestParam(required = false, defaultValue = "0") int ano,
                                                      @RequestParam(required = false) String filtro,
                                                      @RequestParam int ordem) {
        logger.info("api --> Consulta por editora");
        return ResponseEntity.ok().body(livroServico.consultarPorEditora(editora, ano, filtro, ordem));
    }

    @GetMapping(value = "livros", params = "id")
    @Operation(summary = "Consultar livro por ID", description = "Consulta um livro pelo seu ID.")
    public ResponseEntity<Object> consultarPorId(@RequestParam String id){
        logger.info("api --> Consultar livro por ID");
        return ResponseEntity.ok().body(livroServico.consultarPorId(id));
    }

    @PostMapping("livros")
    @Operation(summary = "Cadastrar livro", description = "Cadastra um novo livro para o sistema.")
    public ResponseEntity<Object> cadastrarLivro(@RequestBody Livro livro) {
        logger.info("api --> Cadastrar livro");

        return ResponseEntity.ok().body(livroServico.cadastrarLivro(livro));
    }

    @PatchMapping("livros")
    @Operation(summary = "Editar livro", description = "Edita um novo livro para o sistema.")
    public ResponseEntity<Object> editarLivro(@RequestBody Livro livro){
        logger.info("api --> Editar livro");

        return ResponseEntity.ok().body(livroServico.editarLivro(livro));
    }

    @DeleteMapping("livros/{id}")
    @Operation(summary = "Excluir livro", description = "Exclui um livro do sistema.")
    public ResponseEntity<Object> excluirLivro(@PathVariable("id") String id){
        logger.info("api --> Excluir livro");

        livroServico.excluirLivro(id);

        return ResponseEntity.ok().body("Ok");
    }

}
