package br.com.AnimaMonitoria.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CAMPOS")
public class Campos {

    @Id
    @SequenceGenerator(name = "SEQ_CAMPOS", sequenceName = "SEQ_CAMPOS", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CAMPOS")
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_INSTITUICAO")
    private Long idInstituicao;

    @Column(name = "UNIDADE")
    private String unidade;

    @Column(name = "IMG_CAMPOS")
    private String imgCampos;

    @Column(name = "RESPONSAVEL")
    private String responsavel;

}
