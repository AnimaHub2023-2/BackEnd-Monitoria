package br.com.AnimaMonitoria.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CURSO")
public class Aluno {


    @Id
    @SequenceGenerator(name = "SEQ_ALUNO", sequenceName = "SEQ_ALUNO", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ALUNO")
    @Column(name = "ID")
    private Long id;

    private String nome;

    private String sobrenome;

    private String ra;

    private String email;

    private int semestre;

    private String periodo;


}
