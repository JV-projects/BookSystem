package com.booksystem.booksystem.controller;

import com.booksystem.booksystem.model.PerfilUsuario;
import com.booksystem.booksystem.repository.ICredenciaisRepository;
import com.booksystem.booksystem.service.IPerfilUsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("booksystem/api/")
public class APIPerfilUsuarioController {

    @Autowired
    ICredenciaisRepository credenciaisRepository;

    @Autowired
    IPerfilUsuarioServico perfilUsuarioServico;

    @PostMapping("/perfil")
    public ResponseEntity<Object> registerperfil(@RequestBody PerfilUsuario perfilUsuario){

        if(!credenciaisRepository.findByUsername(perfilUsuario.getUsername()).isPresent())
            return ResponseEntity.badRequest().build();

        perfilUsuarioServico.salvarPerfil(perfilUsuario);

        return ResponseEntity.status(HttpStatus.OK).body("Informações adicionadas");
    }

    @GetMapping(value = "/perfil", params = "username")
    public ResponseEntity<Object> getPerfil(@RequestParam String username){
        if(!credenciaisRepository.findByUsername(username).isPresent())
            return ResponseEntity.badRequest().body("Usuário não encontrado");

        return ResponseEntity.status(HttpStatus.OK).body(perfilUsuarioServico.consultarPerfil(username));
    }

}
