package com.totalshakes.wstotalshakes.repository;

import com.totalshakes.wstotalshakes.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

}
