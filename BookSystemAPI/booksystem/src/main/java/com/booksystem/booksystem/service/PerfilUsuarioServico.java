package com.booksystem.booksystem.service;

import com.booksystem.booksystem.model.Credenciais;
import com.booksystem.booksystem.model.PerfilUsuario;
import com.booksystem.booksystem.repository.ICredenciaisRepository;
import com.booksystem.booksystem.repository.IPerfilUsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfilUsuarioServico implements IPerfilUsuarioServico{
    Logger logger = LogManager.getLogger(this.getClass());

    private ICredenciaisRepository credenciaisRepository;
    private IPerfilUsuarioRepository perfilUsuarioRepository;

    public PerfilUsuarioServico(IPerfilUsuarioRepository perfilUsuarioRepository, ICredenciaisRepository credenciaisRepository) {
        this.perfilUsuarioRepository = perfilUsuarioRepository;
        this.credenciaisRepository = credenciaisRepository;
    }

    @Override
    public Optional<PerfilUsuario> salvarPerfil(PerfilUsuario perfilUsuario) {
        //Verificando se existe o perfil na API
        Optional<PerfilUsuario> pu = perfilUsuarioRepository.findByUsername(perfilUsuario.getUsername());

        //Se não tiver o perfil, ele cria um
        if(!pu.isPresent()){

            logger.info("|---- Serviço - Cadastrando perfil do usuário ----|");

            Optional<Credenciais> credenciais = credenciaisRepository.findByUsername(perfilUsuario.getUsername());
            perfilUsuario.setCredenciais(credenciais.get());

            return Optional.ofNullable(perfilUsuarioRepository.insert(perfilUsuario));

        //Se tiver o perfil, chama o serviço de atualizar, evitando duplicidade
        }else{
           return atualizarPerfil(perfilUsuario);
        }
    }

    @Override
    public Optional<PerfilUsuario> atualizarPerfil(PerfilUsuario perfilUsuario) {
        logger.info("|---- Serviço - Atualizando perfil do usuário ----|");

        return perfilUsuarioRepository.findByUsername(perfilUsuario.getUsername())
                .map(perfil -> {
                    perfil.setNome(perfilUsuario.getNome());
                    perfil.setUsername(perfilUsuario.getUsername());
                    perfil.setCpf(perfilUsuario.getCpf());
                    perfil.setTelefone(perfilUsuario.getTelefone());
                    perfil.setCep(perfilUsuario.getCep());
                    perfil.setRua(perfilUsuario.getRua());
                    perfil.setNumero(perfilUsuario.getNumero());
                    perfil.setBairro(perfilUsuario.getBairro());
                    perfil.setCidade(perfilUsuario.getCidade());
                    perfil.setEstado(perfilUsuario.getEstado());
                    return perfilUsuarioRepository.save(perfil);
                });
    }

    @Override
    public Optional<PerfilUsuario> consultarPerfil(String username) {
        logger.info("|---- Serviço - Consultando usuário pelo username ---|");

        if(perfilUsuarioRepository.findByUsername(username).isPresent()){
            return Optional.ofNullable(perfilUsuarioRepository.findByUsername(username).get());
        }

        return null;
    }
}
