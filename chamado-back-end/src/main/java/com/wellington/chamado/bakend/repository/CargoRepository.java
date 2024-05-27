package com.wellington.chamado.bakend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellington.chamado.bakend.entity.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
