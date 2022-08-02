package com.totalshakes.wstotalshakes.controller;

import com.totalshakes.wstotalshakes.DTO.AdicionalDTO;
import com.totalshakes.wstotalshakes.model.Adicional;
import com.totalshakes.wstotalshakes.service.AdicionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/adicionais")
public class AdicionalController extends BaseController {

//    @Autowired
    private AdicionalService adicionalService;

    @PostMapping("save")
    public ResponseEntity<Adicional> saveAdicional(@Valid @RequestBody AdicionalDTO adicionalDTO) throws IllegalArgumentException {
        Adicional novoAdicional = adicionalService.saveAdicional(adicionalDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoAdicional.getId()).toUri();
        return ResponseEntity.created(location).body(novoAdicional);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<Adicional>> getAllAdicionals() {
        List<Adicional> adicionalsList = adicionalService.getAllAdicionals();
        return ResponseEntity.ok(adicionalsList);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Adicional> getAdicionalById(@Valid @PathVariable("id") Integer idAdicional) throws IllegalArgumentException {
        Adicional adicional = adicionalService.getAdicionalById(idAdicional);
        return ResponseEntity.ok(adicional);
    }

    @PutMapping("/update")
    public ResponseEntity<Adicional> updateAdicional(@Valid @RequestBody AdicionalDTO adicionalDTO) throws IllegalArgumentException {
        adicionalService.updateAdicional(adicionalDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Adicional> deleteAdicionalById(@Valid @PathVariable("id") Integer idAdicional) throws IllegalArgumentException {
        adicionalService.deleteAdicionalById(idAdicional);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
