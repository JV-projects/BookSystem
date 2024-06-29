package com.booksystem.booksystem.service;

import com.booksystem.booksystem.model.PerfilUsuario;

import java.util.Optional;

public interface IPerfilUsuarioServico {
    Optional<PerfilUsuario> atualizarPerfil(PerfilUsuario perfilUsuario);
    Optional<PerfilUsuario> salvarPerfil(PerfilUsuario perfilUsuario);
    Optional<PerfilUsuario> consultarPerfil(String username);
}
