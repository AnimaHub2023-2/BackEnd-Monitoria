package br.com.AnimaMonitoria.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "INSTITUICAO")
public class Instituicao {

    @Id
    @SequenceGenerator(name = "SEQ_INSTITUICAO", sequenceName = "SEQ_INSTITUICAO", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INSTITUICAO")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "IMG_LOGO")
    private String imgLogo;

    @Column(name = "DECRICAO")
    private String descricao;

    @Column(name = "DT_REGISTRO")
    private LocalDateTime dtRegistro;
}
