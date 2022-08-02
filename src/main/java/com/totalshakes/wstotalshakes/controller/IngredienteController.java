package com.totalshakes.wstotalshakes.controller;

import com.totalshakes.wstotalshakes.DTO.IngredienteDTO;
import com.totalshakes.wstotalshakes.exception.IngredienteJaCadastradoException;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontradoException;
import com.totalshakes.wstotalshakes.model.Ingrediente;
import com.totalshakes.wstotalshakes.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/ingredientes")
public class IngredienteController extends BaseController {

    @Autowired
    private IngredienteService ingredienteService;

    @PostMapping("save")
    public ResponseEntity<Ingrediente> saveIngrediente(@Valid @RequestBody IngredienteDTO ingredienteDTO) throws IngredienteJaCadastradoException {
        Ingrediente novoIngrediente = ingredienteService.saveIngrediente(ingredienteDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoIngrediente.getId()).toUri();
        return ResponseEntity.created(location).body(novoIngrediente);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<Ingrediente>> getAllIngredientes() {
        List<Ingrediente> ingredientesList = ingredienteService.getAllIngredientes();
        return ResponseEntity.ok(ingredientesList);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Ingrediente> getIngredienteById(@Valid @PathVariable("id") Integer idIngrediente) throws IngredienteNaoEncontradoException {
        Ingrediente ingrediente = ingredienteService.getIngredienteById(idIngrediente);
        return ResponseEntity.ok(ingrediente);
    }

    @PutMapping("/update")
    public ResponseEntity<Ingrediente> updateIngrediente(@Valid @RequestBody IngredienteDTO ingredienteDTO) throws IngredienteNaoEncontradoException {
        ingredienteService.updateIngrediente(ingredienteDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Ingrediente> deleteIngredienteById(@Valid @PathVariable("id") Integer idIngrediente) throws IngredienteNaoEncontradoException {
        ingredienteService.deleteIngredienteById(idIngrediente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
