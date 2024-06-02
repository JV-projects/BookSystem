package com.booksystem.booksystem.controller;

import com.booksystem.booksystem.model.Livro;
import com.booksystem.booksystem.servico.interfaces.ILivroServico;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("booksystem/api")
public class APILivroController {
    Logger logger = LogManager.getLogger(this.getClass());

    private final ILivroServico livroServico;

    public APILivroController(ILivroServico livroServico) {
        this.livroServico = livroServico;
    }

    @GetMapping("livros")
    public ResponseEntity<Object> consultarLivros() {
        logger.info("api --> Consultar livro");
        return ResponseEntity.ok().body(livroServico.consultarLivros());
    }

    @GetMapping(value = "livros", params = {"titulo", "filtro", "ordem"})
    public ResponseEntity<Object> consultaPorTitulo(@RequestParam String titulo,
                                                    @RequestParam(required = false, defaultValue = "0") int ano,
                                                    @RequestParam(required = false) String filtro,
                                                    @RequestParam int ordem) {

        logger.info("api --> Consulta por Titulo");
        return ResponseEntity.ok().body(livroServico.consultarPorTitulo(titulo, ano, filtro, ordem));
    }

    @GetMapping(value = "livros", params = "isbn")
    public ResponseEntity<Object> consultarPorIsbn(@RequestParam long isbn) {
        logger.info("api --> Consulta por ISBN");
        return ResponseEntity.ok(livroServico.consultarPorIsbn(isbn));
    }

    @GetMapping(value = "livros", params = {"autor", "filtro", "ordem"})
    public ResponseEntity<Object> consultaPorAutor(@RequestParam String autor,
                                                   @RequestParam(required = false, defaultValue = "0") int ano,
                                                   @RequestParam(required = false) String filtro,
                                                   @RequestParam int ordem) {
        logger.info("api --> Consulta por autor");
        return ResponseEntity.ok().body(livroServico.consultarPorAutor(autor, ano, filtro, ordem));
    }

    @GetMapping(value = "livros", params = {"editora", "filtro", "ordem"})
    public ResponseEntity<Object> consultarPorEditora(@RequestParam String editora,
                                                      @RequestParam(required = false, defaultValue = "0") int ano,
                                                      @RequestParam(required = false) String filtro,
                                                      @RequestParam int ordem) {
        logger.info("api --> Consulta por editora");
        return ResponseEntity.ok().body(livroServico.consultarPorEditora(editora, ano, filtro, ordem));
    }

    @GetMapping(value = "livros", params = "id")
    public ResponseEntity<Object> consultarPorId(@RequestParam String id){
        logger.info("api --> Consultar livro por ID");
        return ResponseEntity.ok().body(livroServico.consultarPorId(id));
    }

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

    @DeleteMapping("livros/{id}")
    public ResponseEntity<Object> excluirLivro(@PathVariable("id") String id){
        logger.info("api --> Excluir livro");

        livroServico.excluirLivro(id);

        return ResponseEntity.ok().body("Ok");
    }

}
