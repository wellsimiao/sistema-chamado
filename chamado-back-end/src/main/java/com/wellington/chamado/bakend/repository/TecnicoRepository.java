package com.wellington.chamado.bakend.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellington.chamado.bakend.entity.Tecnico;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, UUID> {

	Optional<Tecnico> findByEmail(String email);
}
