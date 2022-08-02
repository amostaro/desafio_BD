package com.totalshakes.wstotalshakes.service;

import com.totalshakes.wstotalshakes.DTO.AdicionalDTO;
import com.totalshakes.wstotalshakes.model.Adicional;
import com.totalshakes.wstotalshakes.repository.AdicionalRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdicionalService extends BaseService{

//    @Autowired
    private AdicionalRepository adicionalRepository;

    public Adicional saveAdicional(AdicionalDTO adicionalDTO) throws IllegalArgumentException {

        if (ObjectUtils.isEmpty(adicionalDTO.getIngrediente())) {
            throw new IllegalArgumentException("Adicional deve conter ingrediente");
        }

        List<Adicional> adicionalListBanco = this.getAllAdicionals();
        for (Adicional adicionalRepetido : adicionalListBanco) {
            adicionalRepetido = adicionalRepository.findByIngrediente(adicionalDTO.getIngrediente());

            if (adicionalRepetido == null) {
                adicionalDTO.setIngrediente(adicionalDTO.getIngrediente());
            } else {
                throw new IllegalArgumentException();
            }
        }

        return adicionalRepository.save(super.convertToModel(adicionalDTO, Adicional.class));

    }

    public List<Adicional> getAllAdicionals() {

        List<Adicional> adicionalsList = adicionalRepository.findAll();
        return adicionalsList;
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
            adicional.setIngrediente(adicionalDTO.getIngrediente());
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
