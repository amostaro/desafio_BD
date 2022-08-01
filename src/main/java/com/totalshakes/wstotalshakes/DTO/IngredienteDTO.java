package com.totalshakes.wstotalshakes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class IngredienteDTO {

    private Integer id;
    private String nome;
    private String tipo;
    private ArmazemDTO armazemDTO;

}
