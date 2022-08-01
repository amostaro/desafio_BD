//package com.totalshakes.wstotalshakes.service;
//
//import com.totalshakes.wstotalshakes.DTO.IngredienteDTO;
//import com.totalshakes.wstotalshakes.exception.IngredienteJaCadastradoException;
//import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontradoException;
//import com.totalshakes.wstotalshakes.model.Armazem;
//import com.totalshakes.wstotalshakes.model.Ingrediente;
//import com.totalshakes.wstotalshakes.repository.ArmazemRepository;
//import com.totalshakes.wstotalshakes.repository.IngredienteRepository;
//import lombok.RequiredArgsConstructor;
//import org.apache.commons.lang3.ObjectUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@Service
//public class IngredienteService extends BaseService{
//
//    @Autowired
//    private IngredienteRepository ingredienteRepository;
//
//    @Autowired
//    private ArmazemRepository armazemRepository;
//
//    public Ingrediente saveIngrediente(IngredienteDTO ingredienteDTO) throws IngredienteJaCadastradoException {
//
//        if (ObjectUtils.isEmpty(ingredienteDTO) || ingredienteDTO.getNome() == null) {
//            throw new IllegalArgumentException("Ingrediente deve conter nome");
//        }
//
//        List<Ingrediente> ingredientesList = ingredienteRepository.findAll();
//        if (ingredientesList.size() != 0) {
//            for (Ingrediente item : ingredientesList) {
//                item = ingredienteRepository.findByNome(ingredienteDTO.getNome());
//                if (item != null) {
//                    throw new IngredienteJaCadastradoException();
//                }
//            }
//        }
//
//
//        return ingredienteRepository.save(super.convertToModel(armazemDTO, Armazem.class));
//
//
//
//
////        List<Armazem> armazemList = armazemRepository.findAll();
////        if (armazemList.size() != 0) {
////            for (Armazem item : armazemList) {
////                item = armazemRepository.findByNome(ingredienteDTO.getNome());
////                if (item != null) {
////                    throw new IngredienteJaCadastradoException();
////                }
////            }
////        }
////
////        ArmazemDTO armazemDTO = new ArmazemDTO();
////        armazemDTO.setQuantidade(0);
////        Armazem armazemSalvo = armazemRepository.save(super.convertToModel(armazemDTO, Armazem.class));
////
////        ingredienteDTO.setNome(ingredienteDTO.getNome());
////        ingredienteDTO.setTipoIngrediente(ingredienteDTO.getTipoIngrediente());
////        ingredienteDTO.setArmazemDTO(super.convertToDTO(armazemSalvo, ArmazemDTO.class));
////        return ingredienteRepository.save(super.convertToModel(ingredienteDTO, Ingrediente.class));
//
//    }
//
//    public List<Ingrediente> getAllIngredientes() {
//
//        List<Ingrediente> ingredientesList = ingredienteRepository.findAll();
//        return ingredientesList;
//    }
//
//    public Ingrediente getIngredienteById(Integer idIngrediente) throws IngredienteNaoEncontradoException {
//
//        Ingrediente ingrediente = null;
//        if (ObjectUtils.isEmpty(idIngrediente)) {
//            throw new IllegalArgumentException("O id é obrigatório");
//        }
//
//        try {
//            ingrediente = ingredienteRepository.findById(idIngrediente).orElseThrow(
//                    () -> new IngredienteNaoEncontradoException()
//            );
//        } catch (Exception e) {
//            throw new IngredienteNaoEncontradoException();
//        }
//        return ingrediente;
//
//    }
//
////    public void updateIngredienteById(Integer idIngrediente) throws IngredienteNaoEncontradoException {
////
////        Ingrediente ingrediente = this.getIngredienteById(idIngrediente);
////
////        ingrediente.setNome(ingrediente.getNome());
////
////        ingredienteRepository.save(ingrediente);
////    }
//
////    public Ingrediente updateIngrediente(IngredienteDTO ingredienteDTO) throws IngredienteNaoEncontradoException {
////
////        Ingrediente ingrediente = null;
////        if (!ObjectUtils.isEmpty(ingredienteDTO)) {
////            ingrediente = this.getIngredienteById(ingredienteDTO.getId());
////            ingrediente.setNome(ingredienteDTO.getNome());
////            ingrediente.setTipoIngrediente(ingredienteDTO.getTipoIngrediente());
////        } else {
////            throw new IngredienteNaoEncontradoException();
////        }
////
////        return ingredienteRepository.save(ingrediente);
////    }
//
//    public void deleteIngredienteById(Integer idIngrediente) throws IngredienteNaoEncontradoException {
//
//        this.getIngredienteById(idIngrediente); //validação
//
//        ingredienteRepository.deleteById(idIngrediente);
//    }
//
//}
