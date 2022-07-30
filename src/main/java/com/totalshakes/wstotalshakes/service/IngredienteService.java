package com.totalshakes.wstotalshakes.service;

import com.totalshakes.wstotalshakes.DTO.IngredienteDTO;
import com.totalshakes.wstotalshakes.exception.IngredienteJaCadastradoException;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontradoException;
import com.totalshakes.wstotalshakes.model.Ingrediente;
import com.totalshakes.wstotalshakes.repository.IngredienteRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IngredienteService extends BaseService{

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public Ingrediente saveIngrediente(IngredienteDTO ingredienteDTO) throws IngredienteJaCadastradoException {

        if (ObjectUtils.isEmpty(ingredienteDTO) || ingredienteDTO.getNome() == null) {
            throw new IllegalArgumentException("Ingrediente deve conter nome");
        }

        List<Ingrediente> ingredienteListBanco = this.getAllIngredientes();
        for (Ingrediente ingredienteRepetido : ingredienteListBanco) {
            ingredienteRepetido = ingredienteRepository.findByNome(ingredienteDTO.getNome());

            if (ingredienteRepetido == null) {
                ingredienteDTO.setNome(ingredienteDTO.getNome());
            } else {
                throw new IngredienteJaCadastradoException();
            }
        }

        return ingredienteRepository.save(super.convertToModel(ingredienteDTO, Ingrediente.class));

    }

    public List<Ingrediente> getAllIngredientes() {

        List<Ingrediente> ingredientesList = ingredienteRepository.findAll();
        return ingredientesList;
    }

    public Ingrediente getIngredienteById(Integer idIngrediente) throws IngredienteNaoEncontradoException {

        Ingrediente ingrediente = null;
        if (ObjectUtils.isEmpty(idIngrediente)) {
            throw new IllegalArgumentException("O id é obrigatório");
        }

        try {
            ingrediente = ingredienteRepository.findById(idIngrediente).orElseThrow(
                    () -> new IngredienteNaoEncontradoException()
            );
        } catch (Exception e) {
            throw new IngredienteNaoEncontradoException();
        }
        return ingrediente;

    }

    public Ingrediente getIngrediente(IngredienteDTO ingredienteDTO) throws IngredienteNaoEncontradoException {

        Ingrediente ingrediente = this.getIngredienteById(ingredienteDTO.getId());

        //TODO

        return ingredienteRepository.save(ingrediente);
    }

    public void updateIngredienteById(Integer idIngrediente) throws IngredienteNaoEncontradoException {

        //TODO

        Ingrediente ingrediente = this.getIngredienteById(idIngrediente);

        ingredienteRepository.save(ingrediente);
    }

    public Ingrediente updateIngrediente(IngredienteDTO ingredienteDTO) throws IngredienteNaoEncontradoException {

        //TODO

        Ingrediente ingrediente = this.getIngredienteById(ingredienteDTO.getId());

        //TODO

        return ingredienteRepository.save(ingrediente);
    }

    public void deleteIngredienteById(Integer idIngrediente) throws IngredienteNaoEncontradoException {

        //TODO

        this.getIngredienteById(idIngrediente); //validação

        ingredienteRepository.deleteById(idIngrediente);
    }

    public void deleteIngrediente(IngredienteDTO ingredienteDTO) throws IngredienteNaoEncontradoException {

        //TODO

        Ingrediente ingrediente = this.getIngredienteById(ingredienteDTO.getId());

        //TODO

        ingredienteRepository.delete(ingrediente);
    }
}
