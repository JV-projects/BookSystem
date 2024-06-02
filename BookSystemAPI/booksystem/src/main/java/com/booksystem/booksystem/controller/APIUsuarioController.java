package com.booksystem.booksystem.controller;

import com.booksystem.booksystem.repository.IPerfilFuncionarioRepository;
import com.booksystem.booksystem.service.PerfilFuncionarioServico;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booksystem.booksystem.repository.IPerfilUsuarioRepository;
import com.booksystem.booksystem.repository.ICredenciaisRepository;

@RestController
@RequestMapping("booksystem/api")
public class APIUsuarioController {
    Logger logger = LogManager.getLogger(this.getClass());


}
