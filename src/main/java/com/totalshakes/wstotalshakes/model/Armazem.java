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
@Table(name = "armazens")
@PrimaryKeyJoinColumn(name = "ingrediente_id")
public class Armazem extends Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

//    @ManyToOne
//    @JoinColumn(name = "ingrediente_id")
//    private Ingrediente ingrediente;

    @Column(name = "quantidade")
    private Integer quantidade;
}
