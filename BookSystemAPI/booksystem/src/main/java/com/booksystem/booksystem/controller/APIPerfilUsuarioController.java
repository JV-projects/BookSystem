package com.booksystem.booksystem.controller;

import com.booksystem.booksystem.model.PerfilUsuario;
import com.booksystem.booksystem.repository.ICredenciaisRepository;
import com.booksystem.booksystem.service.IPerfilUsuarioServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("booksystem/api/")
@Tag(name = "API Perfil de Usuário", description = "Enpoints para controle do perfil de usuário.")
public class APIPerfilUsuarioController {

    @Autowired
    ICredenciaisRepository credenciaisRepository;

    @Autowired
    IPerfilUsuarioServico perfilUsuarioServico;

    @PostMapping("/perfil")
    @Operation(summary = "Registrar perfil", description = "Registrar perfil")
    public ResponseEntity<Object> registerperfil(@RequestBody PerfilUsuario perfilUsuario){

        if(!credenciaisRepository.findByUsername(perfilUsuario.getUsername()).isPresent())
            return ResponseEntity.badRequest().body("Username inválido");

        perfilUsuarioServico.salvarPerfil(perfilUsuario);

        return ResponseEntity.status(HttpStatus.OK).body("Informações adicionadas");
    }

    @GetMapping(value = "/perfil", params = "username")
    @Operation(summary = "Recuperar perfil", description = "Recupera um perfil pelo username.")
    public ResponseEntity<Object> getPerfil(@RequestParam String username){
        if(!credenciaisRepository.findByUsername(username).isPresent())
            return ResponseEntity.badRequest().body("Usuário não encontrado");

        if(perfilUsuarioServico.consultarPerfil(username) != null)
            return ResponseEntity.status(HttpStatus.OK).body(perfilUsuarioServico.consultarPerfil(username));

        return ResponseEntity.badRequest().body(null);
    }

}
