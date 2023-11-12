package br.com.AnimaMonitoria.model;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "MONITORIA")
public class Monitoria {

    @Id
    @SequenceGenerator(name = "SEQ_MONITORIA", sequenceName = "SEQ_MONITORIA", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MONITORIA")
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_INSTITUICAO")
    private Long idInstituicao;

    @Column(name = "ID_CAMPUS")
    private Long idCampus;

    @Column(name = "NOME_PROFESSOR")
    private String nomeProfessor;

    @Column(name = "SOBRENOME_PROFESSOR")
    private String sobrenomeProfessor;

    @Column(name = "CPF_PROFESSOR")
    private String cpfProfessor;

    @Column(name = "EMAIL_PROFESSOR")
    private String emailProfessor;

    @Column(name = "TELEFONE_PROFESSOR")
    private String telefoneProfessor;

    @Column(name = "MODALIDADE")
    private String modalidade;

    @Column(name = "HORARIO")
    private String horario;

    @Column(name = "DATA")
    private LocalDateTime data;
}
