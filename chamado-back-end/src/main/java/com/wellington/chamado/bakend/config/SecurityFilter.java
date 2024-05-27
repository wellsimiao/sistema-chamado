package com.wellington.chamado.bakend.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wellington.chamado.bakend.entity.Usuario;
import com.wellington.chamado.bakend.repository.UsuarioRepository;
import com.wellington.chamado.bakend.services.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token;

        String authorizationHeader = request.getHeader("Authorization") == null ?
                request.getParameter("Authorization") : request.getHeader("Authorization");


        if(authorizationHeader != null){
            token = authorizationHeader.replace("Bearer ","");
            String email = tokenService.validacaoToken(token);

            Usuario usuario = repository.findByEmail(email);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario,
                    null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request,response);		
		
	}

}
