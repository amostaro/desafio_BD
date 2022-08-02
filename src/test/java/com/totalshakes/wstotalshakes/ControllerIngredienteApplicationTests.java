package com.totalshakes.wstotalshakes;

import com.totalshakes.wstotalshakes.DTO.IngredienteDTO;
import com.totalshakes.wstotalshakes.controller.IngredienteController;
import com.totalshakes.wstotalshakes.exception.IngredienteJaCadastradoException;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontradoException;
import com.totalshakes.wstotalshakes.model.Ingrediente;
import org.junit.jupiter.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.class)
@SpringBootTest
class ControllerIngredienteApplicationTests {

	@Autowired
	private ModelMapper modelMapper;

	public <D> D convertToDTO(Object model, Class<D> dto) { return this.convertTo(model, dto); }

	public <D> D convertTo(Object source, Class<D> destinationType) { return this.modelMapper.map(source, destinationType); }

	@Autowired
	IngredienteController ingredienteController;

	@Test
	@Order(1)
	void testSaveIngrediente() throws IngredienteJaCadastradoException {
		IngredienteDTO ingredienteDTO = new IngredienteDTO();
		ingredienteDTO.setNome("Sorvete");
		ResponseEntity novoIngrediente = ingredienteController.saveIngrediente(ingredienteDTO); //ResponseEntity

		assertEquals(HttpStatus.CREATED, novoIngrediente.getStatusCode());
	}

	@Test
	@Order(2)
	void testGetAllIngredientes() {
		ResponseEntity<List<Ingrediente>> ingredienteList = ingredienteController.getAllIngredientes();

		assertEquals(1, ingredienteList.getBody().size());
	}

	@Test
	@Order(3)
	void testGetIngredienteById() throws IngredienteNaoEncontradoException {
		ResponseEntity<List<Ingrediente>> ingredienteList = ingredienteController.getAllIngredientes();
		for (Ingrediente item : ingredienteList.getBody()) {
			Integer idIngrediente = item.getId();
			ResponseEntity ingredienteById = ingredienteController.getIngredienteById(idIngrediente);

			assertEquals(HttpStatus.OK, ingredienteById.getStatusCode());
		}
	}

	@Test
	@Order(4)
	void testUpdateIngrediente() throws IngredienteNaoEncontradoException {
		ResponseEntity<List<Ingrediente>> ingredienteList = ingredienteController.getAllIngredientes();
		for (Ingrediente item : ingredienteList.getBody()) {
			Integer idIngrediente = item.getId();
			ResponseEntity ingredienteById = ingredienteController.getIngredienteById(idIngrediente);

			Ingrediente ingredienteUpdate = (Ingrediente) ingredienteById.getBody();
			IngredienteDTO ingredienteDTO = convertToDTO(ingredienteUpdate, IngredienteDTO.class);
			ingredienteDTO.setNome("Iogurte");

			ResponseEntity ingredienteUpdated = ingredienteController.updateIngrediente(ingredienteDTO);

			assertEquals(HttpStatus.OK, ingredienteUpdated.getStatusCode());
		}
	}

	@Test
	@Order(5)
	void testDeleteIngredienteById() throws IngredienteNaoEncontradoException{
		ResponseEntity<List<Ingrediente>> ingredienteList = ingredienteController.getAllIngredientes();
		for (Ingrediente item : ingredienteList.getBody()) {
			Integer idIngrediente = item.getId();
			ResponseEntity ingredienteById = ingredienteController.deleteIngredienteById(idIngrediente);

			assertEquals(HttpStatus.OK, ingredienteById.getStatusCode());
		}
	}

	@Test
	@Order(6)
	void testGetAllIngredientesisEmpty() {
		ResponseEntity<List<Ingrediente>> ingredienteList = ingredienteController.getAllIngredientes();

		assertEquals(0, ingredienteList.getBody().size());
	}

}
