package com.totalshakes.wstotalshakes;

import com.totalshakes.wstotalshakes.model.Armazem;
import com.totalshakes.wstotalshakes.model.Ingrediente;
import com.totalshakes.wstotalshakes.repository.ArmazemRepository;
import com.totalshakes.wstotalshakes.repository.IngredienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class WstotalshakesApplicationTests {

	@Autowired
	IngredienteRepository ingredienteRepository;
	@Autowired
	ArmazemRepository armazemRepository;

//	@Test
//	void contextLoads() {
//	}

	@Test
	@BeforeEach
	void testGetIngredientes() {
		ingredienteRepository.findAll();
		armazemRepository.findAll();
	}

	@Test
	void testSaveIngrediente() {
//		Ingrediente ingrediente = new Ingrediente();
//		ingrediente.setNome("Sorvete");
//		ingrediente.setTipo("B");
//
//		Armazem armazem = new Armazem();
//		armazem.setQuantidade(0);
//
//		ingrediente.setArmazem(armazem);
//
//		armazem.setEstoqueIngredientes(ingrediente.getArmazem().getEstoqueIngredientes());
//
//		armazemRepository.save(armazem);
//		ingredienteRepository.save(ingrediente);

		Armazem armazem = new Armazem();
		armazem.setQuantidade(0);
		armazem.setEstoqueIngredientes(new HashSet<Ingrediente>());

		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setNome("Chocolate");
		ingrediente.setTipo("A");
		ingrediente.setArmazem(armazem);

		armazemRepository.save(armazem);
		ingredienteRepository.save(ingrediente);

	}

	void updateIngrediente() {

	}


}
