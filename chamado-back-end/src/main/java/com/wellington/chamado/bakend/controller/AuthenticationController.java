package com.wellington.chamado.bakend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellington.chamado.bakend.dto.AuthenticationDTO;
import com.wellington.chamado.bakend.dto.DadosTokenJwtDTO;
import com.wellington.chamado.bakend.entity.Usuario;
import com.wellington.chamado.bakend.services.TokenService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@Valid @RequestBody AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var authentication = authenticationManager.authenticate(usernamePassword);
        var tokenJWT = tokenService.generateToken((Usuario) authentication.getPrincipal());
		return ResponseEntity.ok().body(new DadosTokenJwtDTO(tokenJWT));
	}

}
