package com.wellington.chamado.bakend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wellington.chamado.bakend.entity.Usuario;
import com.wellington.chamado.bakend.repository.UsuarioRepository;




@Service
public class AuthorizationService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario entity = repository.findByEmail(email);
        if (entity == null) {
            throw new IllegalArgumentException("Email não encontrado");
        }
        return entity;
	}

}
