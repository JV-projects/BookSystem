package com.booksystem.booksystem.service;

import com.booksystem.booksystem.model.Credenciais;
import com.booksystem.booksystem.repository.ICredenciaisRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutorizacaoServico implements UserDetailsService{

    private ICredenciaisRepository credenciaisRepository;

    public AutorizacaoServico(ICredenciaisRepository credenciaisRepository) {
        this.credenciaisRepository = credenciaisRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return credenciaisRepository.findByUsername(username).get();
    }
}
