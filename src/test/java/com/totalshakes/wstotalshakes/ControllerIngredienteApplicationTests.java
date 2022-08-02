package com.totalshakes.wstotalshakes;

import com.totalshakes.wstotalshakes.DTO.IngredienteDTO;
import com.totalshakes.wstotalshakes.controller.IngredienteController;
import com.totalshakes.wstotalshakes.exception.IngredienteJaCadastradoException;
import com.totalshakes.wstotalshakes.model.Ingrediente;
import com.totalshakes.wstotalshakes.service.IngredienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ControllerIngredienteApplicationTests {

	@Autowired
	IngredienteController ingredienteController;
	@Autowired
	IngredienteService ingredienteService;

	@Test
	void contextLoads() {
	}

	@Test
	void testSaveIngrediente() throws IngredienteJaCadastradoException {
		IngredienteDTO ingredienteDTO = new IngredienteDTO();
		ingredienteDTO.setNome("Sorvete");
		ResponseEntity novoIngrediente = ingredienteController.saveIngrediente(ingredienteDTO); //ResponseEntity

		assertEquals(HttpStatus.CREATED, novoIngrediente.getStatusCode());
	}

}
