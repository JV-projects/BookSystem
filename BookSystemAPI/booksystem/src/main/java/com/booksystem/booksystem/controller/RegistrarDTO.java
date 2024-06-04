package com.booksystem.booksystem.controller;

import com.booksystem.booksystem.model.RoleUsuario;

public record RegistrarDTO(String username, String senha, RoleUsuario role) {
}
