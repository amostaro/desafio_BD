package com.totalshakes.wstotalshakes.controller;

import com.totalshakes.wstotalshakes.DTO.IngredienteDTO;
import com.totalshakes.wstotalshakes.model.Ingrediente;
import com.totalshakes.wstotalshakes.service.IngredienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class IngredienteController extends BaseController {

    final IngredienteService ingredienteService;

    @PostMapping("/save")
    public ResponseEntity<Ingrediente> saveIngrediente(@Valid @RequestBody IngredienteDTO ingredienteDTO) {
        ingredienteService.saveIngrediente(ingredienteDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/listartodos")
    public ResponseEntity<List<Ingrediente>> getAllIngredientes() {
        List<Ingrediente> ingredienteList = ingredienteService.getAllIngredientes();
        return ResponseEntity.ok(ingredienteList);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Ingrediente> getIngredienteById(@Valid @PathVariable("id") Integer idIngrediente) {
        Ingrediente ingrediente = ingredienteService.getIngredienteById(idIngrediente);
        return ResponseEntity.ok(ingrediente);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ingrediente> updateIngredienteById(@Valid @PathVariable("id") Integer idIngrediente) {
        ingredienteService.updateIngredienteById(idIngrediente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Ingrediente> updateIngrediente(@Valid @RequestBody IngredienteDTO ingredienteDTO) {
        ingredienteService.updateIngrediente(ingredienteDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Ingrediente> deleteIngredienteById(@Valid @PathVariable("id") Integer idIngrediente) {
        ingredienteService.deleteIngredienteById(idIngrediente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Ingrediente> deleteIngrediente(@Valid @RequestBody IngredienteDTO ingredienteDTO) {
        ingredienteService.deleteIngrediente(ingredienteDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
