package com.wellington.chamado.bakend.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellington.chamado.bakend.entity.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
	
	Optional<Cliente> findByEmail(String email);

}
