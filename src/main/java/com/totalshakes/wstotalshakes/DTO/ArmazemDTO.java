package com.totalshakes.wstotalshakes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ArmazemDTO {

    private Integer id;
    private Integer quantidade;
    private Set<IngredienteDTO> estoqueIngredientesDTO;

}
