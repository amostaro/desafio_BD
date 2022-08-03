package com.totalshakes.wstotalshakes.service;

import com.totalshakes.wstotalshakes.DTO.AdicionalDTO;
import com.totalshakes.wstotalshakes.DTO.IngredienteDTO;
import com.totalshakes.wstotalshakes.model.Adicional;
import com.totalshakes.wstotalshakes.model.Ingrediente;
import com.totalshakes.wstotalshakes.repository.AdicionalRepository;
import com.totalshakes.wstotalshakes.repository.IngredienteRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@RequiredArgsConstructor
@Service
public class AdicionalService extends BaseService{

    @Autowired
    private AdicionalRepository adicionalRepository;
    @Autowired
    private IngredienteRepository ingredienteRepository;

    public Adicional saveAdicional(AdicionalDTO adicionalDTO) throws IllegalArgumentException {

        if (ObjectUtils.isEmpty(adicionalDTO.getIngredienteDTO())) {
            throw new IllegalArgumentException("Adicional deve conter ingrediente");
        }

        List<Adicional> adicionalListBanco = this.getAllAdicionais();
        if (!ObjectUtils.isEmpty(adicionalListBanco)) {
            for (Adicional adicionalRepetido : adicionalListBanco) {
                adicionalRepetido = adicionalRepository.findByIngrediente(super.convertToModel(adicionalDTO.getIngredienteDTO(), Ingrediente.class));
                if (adicionalRepetido != null || !ObjectUtils.isEmpty(adicionalRepetido)) {
                    throw new IllegalArgumentException();
                }
            }
        }
        IngredienteDTO ingredienteDTO = new IngredienteDTO();
        ingredienteDTO.setNome(adicionalDTO.getIngredienteDTO().getNome());
        ingredienteRepository.save(super.convertToModel(ingredienteDTO, Ingrediente.class));

        adicionalDTO.setIngredienteDTO(adicionalDTO.getIngredienteDTO());
        return adicionalRepository.save(super.convertToModel(adicionalDTO, Adicional.class));

    }

    public List<Adicional> getAllAdicionais() {

        List<Adicional> adicionaisList = adicionalRepository.findAll();
        return adicionaisList;
    }

    public Adicional getAdicionalById(Integer idAdicional) throws IllegalArgumentException {

        Adicional adicional = null;
        if (ObjectUtils.isEmpty(idAdicional)) {
            throw new IllegalArgumentException("O id é obrigatório");
        }

        try {
            adicional = adicionalRepository.findById(idAdicional).orElseThrow(
                    () -> new IllegalArgumentException()
            );
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return adicional;

    }

    public Adicional updateAdicional(AdicionalDTO adicionalDTO) throws IllegalArgumentException {

        Adicional adicional = null;
        if (!ObjectUtils.isEmpty(adicionalDTO)) {
            adicional = this.getAdicionalById(adicionalDTO.getId());
            adicional.setIngrediente(super.convertToModel(adicionalDTO.getIngredienteDTO(), Ingrediente.class));
        } else {
            throw new IllegalArgumentException();
        }

        return adicionalRepository.save(adicional);
    }

    public void deleteAdicionalById(Integer idAdicional) throws IllegalArgumentException {

        this.getAdicionalById(idAdicional); //validação

        adicionalRepository.deleteById(idAdicional);
    }

}
