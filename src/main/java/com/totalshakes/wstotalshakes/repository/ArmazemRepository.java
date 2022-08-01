package com.totalshakes.wstotalshakes.repository;

import com.totalshakes.wstotalshakes.model.Armazem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmazemRepository extends JpaRepository<Armazem, Integer> {

    Armazem findByNome(String nome);

}
