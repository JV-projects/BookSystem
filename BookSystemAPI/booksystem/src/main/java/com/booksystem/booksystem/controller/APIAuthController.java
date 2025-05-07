package com.booksystem.booksystem.controller;


import com.booksystem.booksystem.config.seguranca.TokenService;
import com.booksystem.booksystem.model.Credenciais;
import com.booksystem.booksystem.model.PerfilUsuario;
import com.booksystem.booksystem.model.RoleUsuario;
import com.booksystem.booksystem.service.ICredenciaisServico;
import com.booksystem.booksystem.service.IPerfilUsuarioServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.booksystem.booksystem.repository.ICredenciaisRepository;

@RestController
@RequestMapping("booksystem/auth/")
@Tag(name = "API Autenticação", description = "Enpoints de cadastro e autenticação.")
public class APIAuthController {
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ICredenciaisRepository credenciaisRepository;

    @Autowired
    ICredenciaisServico credenciaisServico;

    @Autowired
    IPerfilUsuarioServico perfilUsuarioServico;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    @Operation(summary = "Autenticação", description = "Autentica o usuário na API")
    public ResponseEntity<Object> login(@RequestBody CredenciaisDTO credenciaisDTO){
        var usernameSenha = new UsernamePasswordAuthenticationToken(credenciaisDTO.username(), credenciaisDTO.senha());
        var auth = this.authenticationManager.authenticate(usernameSenha);

        var token = tokenService.gerarToken((Credenciais) auth.getPrincipal());

        return ResponseEntity.status(HttpStatus.OK).body(token);
    }

    @PostMapping("/register")
    @Operation(summary = "Cadastro de usuário", description = "Cadastra um usuário na plataforma.")
    public ResponseEntity<Object> registrar(@RequestBody RegistrarDTO registrarDTO){

        if(credenciaisRepository.findByUsername(registrarDTO.username()).isPresent())
            return ResponseEntity.badRequest().build();

        String senhaEncrypted = new BCryptPasswordEncoder().encode(registrarDTO.senha());
        Credenciais credenciais = new Credenciais(registrarDTO.username(), senhaEncrypted, registrarDTO.role());


        if(credenciais.getRole() == null) {
            credenciais.setRole(RoleUsuario.USER);
        }

        credenciaisRepository.insert(credenciais);

        return ResponseEntity.status(HttpStatus.OK).body("Conta criada");
    }

    @DeleteMapping(value = "/credenciais", params = "username")
    @Operation(summary = "Deletar credeciais", description = "Deletando usuário e suas credenciais")
    public ResponseEntity<Object> deletePerfil(@RequestParam String username){
        if(!credenciaisRepository.findByUsername(username).isPresent())
            return ResponseEntity.badRequest().body("Usuário não encontrado");

        credenciaisServico.deleteCredenciais(username);
        return ResponseEntity.status(HttpStatus.OK).body("Informações deletadas");
    }

}
