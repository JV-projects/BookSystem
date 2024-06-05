package com.booksystem.booksystem.config.seguranca;

import com.booksystem.booksystem.model.Credenciais;
import com.booksystem.booksystem.repository.ICredenciaisRepository;
import com.booksystem.booksystem.service.AutorizacaoServico;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service
public class SecurityFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    private ICredenciaisRepository credenciaisRepository;

    private AutorizacaoServico autorizacaoServico;

    public SecurityFilter(TokenService tokenService, ICredenciaisRepository credenciaisRepository, AutorizacaoServico autorizacaoServico) {
        this.tokenService = tokenService;
        this.autorizacaoServico = autorizacaoServico;
        this.credenciaisRepository = credenciaisRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String jwt = recuperarToken(request);

        if (jwt != null) {
            String validarToken = tokenService.validarToken(jwt);
            UserDetails userDetails = credenciaisRepository.findByUsername(validarToken).get();

            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);

        }

        filterChain.doFilter(request, response);

    }

    private String recuperarToken(HttpServletRequest request) {
        String authReader = request.getHeader("Authorization");

        if (authReader != null) {
            return authReader.replace("Bearer ", "");
        }

        return null;
    }
}
