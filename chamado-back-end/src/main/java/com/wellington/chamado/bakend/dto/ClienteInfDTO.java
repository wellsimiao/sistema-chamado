package com.wellington.chamado.bakend.dto;

import java.util.UUID;

import com.wellington.chamado.bakend.entity.Cliente;




public class ClienteInfDTO {

	private UUID id;
	private String nome;
	private String email;

	public ClienteInfDTO() {
	}

	public ClienteInfDTO(Cliente entity) {
		id = entity.getId();
		nome = entity.getNome();
		email = entity.getEmail();
	}

	public ClienteInfDTO(UUID id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
