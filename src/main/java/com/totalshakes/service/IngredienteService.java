package com.totalshakes.service;

import com.totalshakes.DTO.IngredienteDTO;
import com.totalshakes.exception.IngredienteNaoEncontradoException;
import com.totalshakes.model.Ingrediente;
import com.totalshakes.repository.IngredienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IngredienteService extends BaseService{

    private IngredienteRepository ingredienteRepository;
    public Ingrediente saveIngrediente(IngredienteDTO ingredienteDTO) {

        //TODO

        Ingrediente ingrediente = super.convertToModel(ingredienteDTO, Ingrediente.class);
        return ingredienteRepository.save(ingrediente);
    }

    public List<Ingrediente> getAllIngredientes() {

        //TODO

        List<Ingrediente> ingredientesList = ingredienteRepository.findAll();
        return ingredientesList;
    }

    public Ingrediente getIngredienteById(Integer idIngrediente) {

        //TODO

        return ingredienteRepository.findById(idIngrediente).orElseThrow(
                () -> new IngredienteNaoEncontradoException()
        );
    }

    public void updateIngredienteById(Integer idIngrediente) {

        //TODO

        Ingrediente ingrediente = this.getIngredienteById(idIngrediente);

        ingredienteRepository.save(ingrediente);
    }

    public Ingrediente updateIngrediente(IngredienteDTO ingredienteDTO) {

        //TODO

        Ingrediente ingrediente = this.getIngredienteById(ingredienteDTO.getId());

        //TODO

        return ingredienteRepository.save(ingrediente);
    }

    public void deleteIngredienteById(Integer idIngrediente) {

        //TODO

        this.getIngredienteById(idIngrediente); //validação

        ingredienteRepository.deleteById(idIngrediente);
    }

    public void deleteIngrediente(IngredienteDTO ingredienteDTO) {

        //TODO

        Ingrediente ingrediente = this.getIngredienteById(ingredienteDTO.getId());

        //TODO

        ingredienteRepository.delete(ingrediente);
    }
}
