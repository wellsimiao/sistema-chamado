package com.wellington.chamado.bakend.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.wellington.chamado.bakend.entity.Cargo;
import com.wellington.chamado.bakend.entity.Usuario;



@Service
public class TokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;
	
	private static final String ISSUER = "Chamado";

	public String generateToken(Usuario usuario) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			 String rolesAsString = String.join(",", usuario.getCargos().stream()
                     .map(Cargo::getAuthority).collect(Collectors.toList()));
			
			String token = JWT.create().withIssuer(ISSUER)
					.withSubject(usuario.getEmail())
					.withClaim("id", usuario.getId().toString())
					.withClaim("nome", usuario.getNome())
					.withClaim("email", usuario.getEmail())
					.withClaim("roles", rolesAsString)					
					.withExpiresAt(genExpiInstance())
					.sign(algorithm);

			return token;
		} catch (JWTCreationException e) {
			throw new RuntimeException("Erro na hora de gerar o token");
		}

	}

	public String validacaoToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm).withIssuer(ISSUER).build().verify(token).getSubject();
		} catch (JWTCreationException e) {
			return "";
		}
	}

	private Instant genExpiInstance() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}

}
