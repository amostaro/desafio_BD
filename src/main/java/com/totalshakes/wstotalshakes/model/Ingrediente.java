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
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    //EnumTipoIngrediente
    @Column(name = "tipo_ingrediente", length = 1)
    private String tipoIngrediente;

//    @ManyToOne
//    @JoinColumn(name = "armazem_id")
//    private Armazem armazem;

//    @OneToMany
//    private Adicional adicional;
}
