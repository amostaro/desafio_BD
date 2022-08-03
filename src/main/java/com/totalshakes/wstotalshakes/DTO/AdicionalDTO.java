package com.totalshakes.wstotalshakes.DTO;

import com.totalshakes.wstotalshakes.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AdicionalDTO {

    private Integer id;
    private IngredienteDTO ingredienteDTO;

}
