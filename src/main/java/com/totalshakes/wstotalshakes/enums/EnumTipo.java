package com.totalshakes.wstotalshakes.enums;

import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Arrays;

public enum EnumTipo {

    BASE("B", "BASE"),
    ADICIONAL("A", "ADICIONAL"),
    TOPPING("T", "TOPPING");

    @Getter
    private String codigo;
    @Getter
    private String descricao;

    EnumTipo(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static EnumTipo valueOfCodigo(String codigo) {
        if (StringUtils.isEmpty(codigo)) {
            return null;
        }
        return Arrays.stream(EnumTipo.values())
                .filter(element -> element.getCodigo().equalsIgnoreCase(codigo))
                .findAny()
                .orElse(null);
    }
}
