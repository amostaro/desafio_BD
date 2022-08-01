package com.totalshakes.wstotalshakes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ingredientes")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    //EnumTipo (base, adicional, topping)
    @Column(name = "tipo", length = 1)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "armazens_id") //codigo no estoque
    private Armazem armazem;

}
