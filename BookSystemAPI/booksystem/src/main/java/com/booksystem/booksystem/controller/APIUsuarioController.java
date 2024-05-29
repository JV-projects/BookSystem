package com.booksystem.booksystem.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booksystem.booksystem.model.UsuarioComum;
import com.booksystem.booksystem.repository.IUsuarioComumRepository;
import com.booksystem.booksystem.repository.IUsuarioRepository;

@RestController
@RequestMapping("booksystem/api")
public class APIUsuarioController {
    Logger logger = LogManager.getLogger(this.getClass());

    private IUsuarioComumRepository usuarioComumRepository;
    private IUsuarioRepository usuarioRepository;

    public APIUsuarioController(IUsuarioComumRepository usuarioComumRepository, IUsuarioRepository usuarioRepository){
        this.usuarioComumRepository = usuarioComumRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("usuarioscomum")
    public ResponseEntity<Object> getUsuariosComum(){
        logger.info("Consultando usuários");
        return ResponseEntity.ok()
                .body(usuarioComumRepository.findAll());
    }

    @GetMapping("usuarios")
    public ResponseEntity<Object> getUsuarios(){
        logger.info("Consultando usuários");
        return ResponseEntity.ok()
                .body(usuarioRepository.findAll());
    }

    @PostMapping("usuariocomum")
    public ResponseEntity<Object> postUsuarios(@RequestBody UsuarioComum usuarioComum){
        logger.info("Consultando usuários");
        return ResponseEntity.ok()
                .body(usuarioComumRepository.save(usuarioComum));
    }

}
