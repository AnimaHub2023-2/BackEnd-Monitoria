package br.com.AnimaMonitoria.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CURSO")
public class Curso {

    @Id
    @SequenceGenerator(name = "SEQ_CURSO", sequenceName = "SEQ_CURSO", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CURSO")
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_CAMPOS")
    private Long idCampos;

    @Column(name = "NOME")
    private String nome;
}
