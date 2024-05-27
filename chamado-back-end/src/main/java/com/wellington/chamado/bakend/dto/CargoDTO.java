package com.wellington.chamado.bakend.dto;


import com.wellington.chamado.bakend.entity.Cargo;

import lombok.Data;

@Data
public class CargoDTO {

	private Long id;
	private String authority;

	public CargoDTO() {
	}

	public CargoDTO(Long id, String authority) {
		super();
		this.id = id;
		this.authority = authority;
	}

	public CargoDTO(Cargo entity) {
		id = entity.getId();
		authority = entity.getAuthority();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
