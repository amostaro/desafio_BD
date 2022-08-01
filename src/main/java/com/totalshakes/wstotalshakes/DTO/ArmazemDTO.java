package com.totalshakes.wstotalshakes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;

@Data
//@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ArmazemDTO extends IngredienteDTO{

    private Integer quantidade;
}
