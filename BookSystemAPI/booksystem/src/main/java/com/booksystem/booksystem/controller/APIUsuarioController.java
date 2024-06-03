package com.booksystem.booksystem.controller;

import com.booksystem.booksystem.model.Credenciais;
import com.booksystem.booksystem.repository.IPerfilFuncionarioRepository;
import org.apache.coyote.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.booksystem.booksystem.repository.IPerfilUsuarioRepository;
import com.booksystem.booksystem.repository.ICredenciaisRepository;

@RestController
@RequestMapping("booksystem/api/")
public class APIUsuarioController {
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Credenciais credenciais){
        var usernamePassword = new UsernamePasswordAuthenticationToken(credenciais.getUsername(), credenciais.getPassword());
        var auth = authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.status(HttpStatus.OK).body("Autenticado");
    }



}
