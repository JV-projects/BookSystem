package com.booksystem.booksystem.service;

import com.booksystem.booksystem.repository.ICredenciaisRepository;
import com.booksystem.booksystem.repository.IPerfilUsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CredenciaisServico implements ICredenciaisServico{
    Logger logger = LogManager.getLogger(this.getClass());

    private ICredenciaisRepository credenciaisRepository;
    private IPerfilUsuarioRepository perfilUsuarioRepository;

    public CredenciaisServico(IPerfilUsuarioRepository perfilUsuarioRepository, ICredenciaisRepository credenciaisRepository) {
        this.perfilUsuarioRepository = perfilUsuarioRepository;
        this.credenciaisRepository = credenciaisRepository;
    }

    @Override
    public void deleteCredenciais(String username) {

        logger.info("|--- Serviço - deletando credeciais do usuário---|");

        if(credenciaisRepository.findByUsername(username).isPresent()){
            credenciaisRepository.deleteByUsername(username);
        }

        if(perfilUsuarioRepository.findByUsername(username).isPresent()){
            perfilUsuarioRepository.deleteByUsername(username);
        }

    }
}
