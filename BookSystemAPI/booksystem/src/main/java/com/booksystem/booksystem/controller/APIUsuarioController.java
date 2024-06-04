package com.booksystem.booksystem.controller;

import com.booksystem.booksystem.config.seguranca.SecurityConfigurations;
import com.booksystem.booksystem.config.seguranca.TokenService;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.booksystem.booksystem.repository.IPerfilUsuarioRepository;
import com.booksystem.booksystem.repository.ICredenciaisRepository;

@RestController
@RequestMapping("booksystem/auth/")
public class APIUsuarioController {
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ICredenciaisRepository credenciaisRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody CredenciaisDTO credenciaisDTO){
        var usernameSenha = new UsernamePasswordAuthenticationToken(credenciaisDTO.username(), credenciaisDTO.senha());
        var auth = this.authenticationManager.authenticate(usernameSenha);

        var token = tokenService.gerarToken((Credenciais) auth.getPrincipal());

        return ResponseEntity.status(HttpStatus.OK).body(token);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registrar(@RequestBody RegistrarDTO registrarDTO){

        if(credenciaisRepository.findByUsername(registrarDTO.username()).isPresent())
            return ResponseEntity.badRequest().build();

        String senhaEncrypted = new BCryptPasswordEncoder().encode(registrarDTO.senha());
        Credenciais credenciais = new Credenciais(registrarDTO.username(), senhaEncrypted, registrarDTO.role());

        credenciaisRepository.insert(credenciais);

        return ResponseEntity.status(HttpStatus.OK).body("Conta criada");
    }



}
