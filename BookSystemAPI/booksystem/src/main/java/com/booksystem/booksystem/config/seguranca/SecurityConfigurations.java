package com.booksystem.booksystem.config.seguranca;

import com.booksystem.booksystem.model.RoleUsuario;
import com.booksystem.booksystem.service.AutorizacaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    private AutorizacaoServico userDetailsService;

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        return httpSecurity
                .csrf(csrf-> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(HttpMethod.POST, "/booksystem/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/booksystem/auth/register").permitAll()
                        .requestMatchers(HttpMethod.GET, "/booksystem/api/livros").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "/booksystem/api/emprestimos").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder){
//        UserDetails user = User.withUsername("jaaj@fatec")
//                .password(encoder.encode("123"))
//                .roles("ADMIN", "USER")
//                .build();
//
//        UserDetails user2 = User.withUsername("carjooj@fatec")
//                .password(encoder.encode("123"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, user2);
//    }

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}   
