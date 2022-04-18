package com.cvg.crudpersonas.repository;

import com.cvg.crudpersonas.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
